package com.xia.timeslip.domain.fetcher

import com.xia.timeslip.data.cache.MemoryCache
import com.xia.timeslip.domain.result_listener.RequestType
import com.xia.timeslip.domain.result_listener.ResultListener
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Chatikyan on 04.08.2017.
 */
@Singleton
class Fetcher @Inject constructor(private val disposable: CompositeDisposable,
                                  private val memoryCache: MemoryCache) {

    private val requestMap = ConcurrentHashMap<RequestType, Status>()

    private fun <T> getIOToMainTransformer(): SingleTransformer<T, T> {
        return SingleTransformer {
            it.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> fetch(flowable: Flowable<T>, requestType: RequestType,
                  resultListener: ResultListener, success: (T) -> Unit) {
        disposable.add(flowable //请求接口放到io线程中
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //请求接后回调到主线程中，做doOn操作，显示loading状态（AUTH状态）
                .doOnSubscribe { resultListener startAndAdd requestType }
                //订阅，发送请求，判断请求接口的数据，请求成功回调success函数，否则调用onError，调用onRequestError
                .subscribe(onSuccess<T> (requestType, success),
                        resultListener.onError(requestType)))
    }

    fun <T> fetch(observable: Observable<T>, requestType: RequestType,
                  resultListener: ResultListener, success: (T) -> Unit) {
        disposable.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { resultListener startAndAdd requestType }
                .subscribe(onSuccess<T>(requestType, success),
                        resultListener.onError(requestType)))
    }

    fun <T> fetch(single: Single<T>, requestType: RequestType,
                  resultListener: ResultListener, success: (T) -> Unit) {
        disposable.add(single
                .compose(getIOToMainTransformer())
                .doOnSubscribe { resultListener startAndAdd requestType }
                .subscribe(onSuccess<T>(requestType, success),
                        resultListener.onError(requestType)))
    }

    fun complete(completable: Completable, requestType: RequestType,
                 resultListener: ResultListener, success: () -> Unit) {
        disposable.add(completable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { resultListener startAndAdd requestType }
                .subscribe({
                    requestMap.replace(requestType, Status.SUCCESS)
                    success()
                }, resultListener.onError(requestType)))
    }

    private infix fun ResultListener.startAndAdd(requestType: RequestType) {
        onRequestStart(requestType)
        if (requestType != RequestType.TYPE_NONE)
            requestMap.put(requestType, Status.LOADING)
    }

    private fun ResultListener.onError(requestType: RequestType): (Throwable) -> Unit {
        return {
            requestMap.replace(requestType, Status.ERROR)
            onRequestError(requestType, it.message)
        }
    }

    private fun <T> onSuccess(requestType: RequestType, success: (T) -> Unit): (T) -> Unit {
        return {
            //请求是否成功
            val status = if (it is List<*> && it.isEmpty()) {
                Status.EMPTY_SUCCESS
            } else {
                memoryCache.put(requestType, it)
                Status.SUCCESS
            }
            requestMap.replace(requestType, status)
            success(it)
        }
    }

    fun hasActiveRequest(): Boolean = requestMap.isNotEmpty()

    fun getRequestStatus(requestType: RequestType) = requestMap.getOrElse(requestType, { Status.IDLE })

    fun removeRequest(requestType: RequestType) {
        requestMap.remove(requestType)
    }

    fun clear() {
        disposable.clear()
    }
}