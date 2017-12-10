package com.xia.timeslip.presentation.screen.one

import com.xia.timeslip.domain.entity.Essay
import com.xia.timeslip.domain.interactor.DataInteractor
import com.xia.timeslip.presentation.mvp.api.ApiPresenter
import javax.inject.Inject

/**
 * one
 * Created by xiahao on 2017/11/21.
 */
class OnePresenter @Inject constructor(private val oneInteractor: DataInteractor)
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
        val success = { it: List<Essay> ->
            if (it.isNotEmpty()) {
                view?.oneReadList(it)
                getOneReadDetail(it[0].content_id!!)
            } else {
                view?.hideLoading()
                view?.showNoRead() ?: Unit
            }
        }
        view?.showLoading()
        fetch(oneInteractor.getOneEssayList(), ONE_READS, success)
    }

    override fun getOneReadDetail(content_id: String) {
        fetch(oneInteractor.getReadDetail(content_id), ONE_READS) {
            view?.hideLoading()
            if (!it.hp_content.isNullOrBlank()) {
                view?.showReadDetail(it) ?: Unit
            } else {
                view?.showNoRead()
            }
        }
    }


    override fun onRequestStart() {
//        super.onRequestStart()
//        view?.showLoading()
    }

    override fun onRequestError(errorMessage: String?) {
        super.onRequestError(errorMessage)
        view?.showNoRead()
        view?.hideLoading()
        view?.showError(errorMessage)
    }
}