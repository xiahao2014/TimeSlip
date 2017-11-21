package com.xia.timeslip.presentation.mvp.api

import android.support.annotation.CallSuper
import com.xia.timeslip.domain.fetcher.Fetcher
import com.xia.timeslip.domain.fetcher.Status
import com.xia.timeslip.domain.result_listener.RequestType
import com.xia.timeslip.domain.result_listener.ResultListener
import com.xia.timeslip.presentation.mvp.base.BaseContract
import com.xia.timeslip.presentation.mvp.base.BasePresenter
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Chatikyan on 04.08.2017.
 */

abstract class ApiPresenter<VIEW : BaseContract.View> : BasePresenter<VIEW>(), ResultListener {

    @Inject
    protected lateinit var fetcher: Fetcher

    private val TYPE_NONE = RequestType.TYPE_NONE
    protected val AUTH: RequestType = RequestType.AUTH
    protected val POPULAR_SHOTS = RequestType.POPULAR_SHOTS
    protected val RECENT_SHOTS = RequestType.RECENT_SHOTS
    protected val FOLLOWINGS_SHOTS = RequestType.FOLLOWINGS_SHOTS
    protected val ONE_READS = RequestType.ONE_READS
    protected val COMMENTS = RequestType.COMMENTS
    protected val LIKE = RequestType.LIKE
    protected val SUCCESS = Status.SUCCESS
    protected val LOADING = Status.LOADING
    protected val ERROR = Status.ERROR
    protected val EMPTY_SUCCESS = Status.EMPTY_SUCCESS

    protected infix fun RequestType.statusIs(status: Status) = fetcher.getRequestStatus(this) == status

    protected val RequestType.status
        get() = fetcher.getRequestStatus(this)

    fun <TYPE> fetch(flowable: Flowable<TYPE>,
                     requestType: RequestType = TYPE_NONE, success: (TYPE) -> Unit) {
        fetcher.fetch(flowable, requestType, this, success)
    }

    fun <TYPE> fetch(observable: Observable<TYPE>,
                     requestType: RequestType = TYPE_NONE, success: (TYPE) -> Unit) {
        fetcher.fetch(observable, requestType, this, success)
    }

    fun <TYPE> fetch(single: Single<TYPE>,
                     requestType: RequestType = TYPE_NONE, success: (TYPE) -> Unit) {
        fetcher.fetch(single, requestType, this, success)
    }

    fun complete(completable: Completable,
                 requestType: RequestType = TYPE_NONE, success: () -> Unit = {}) {
        fetcher.complete(completable, requestType, this, success)
    }

    @CallSuper
    override fun onPresenterDestroy() {
        super.onPresenterDestroy()
        fetcher.clear()
    }

    @CallSuper
    override fun onRequestStart(requestType: RequestType) {
        onRequestStart()
    }

    @CallSuper
    override fun onRequestError(requestType: RequestType, errorMessage: String?) {
        onRequestError(errorMessage)
    }
}