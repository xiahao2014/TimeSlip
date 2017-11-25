package com.xia.timeslip.presentation.screen.one

import com.xia.timeslip.domain.interactor.OneInteractor
import com.xia.timeslip.presentation.mvp.api.ApiPresenter
import javax.inject.Inject

/**
 * Created by xiahao on 2017/11/21.
 */
class OnePresenter @Inject constructor(private val oneInteractor: OneInteractor)
    : ApiPresenter<OneContract.View>(), OneContract.Presenter {


//    @OnLifecycleEvent(value = Lifecycle.Event.ON_START)
//    fun onStart() {
//        when (ONE_READS.status) {
//            LOADING -> view?.showLoading()
//            EMPTY_SUCCESS, ERROR -> view?.showNoRead()
//        //取缓存数据
////            else -> view?.onDataReceive(userInteractor.getUserLikesFromMemory())
//        }
//    }

    override fun onPresenterCreate() {
        super.onPresenterCreate()
        fetch(oneInteractor.getAndroidData(), ONE_READS) {
            view?.hideLoading()
            print(it)
        }
    }


    override fun onRequestStart() {
        super.onRequestStart()
        view?.showLoading()
    }

    override fun onRequestError(errorMessage: String?) {
        super.onRequestError(errorMessage)
        view?.showNoRead()
        view?.hideLoading()
        view?.showError(errorMessage)
    }
}