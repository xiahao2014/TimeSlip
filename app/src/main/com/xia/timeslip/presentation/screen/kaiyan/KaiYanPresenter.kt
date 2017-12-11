package com.xia.timeslip.presentation.screen.kaiyan

import com.xia.timeslip.domain.interactor.DataInteractor
import com.xia.timeslip.presentation.mvp.api.ApiPresenter
import javax.inject.Inject

/**
 * one
 * Created by xiahao on 2017/11/21.
 */
class KaiYanPresenter @Inject constructor(private val kaiYanInteractor: DataInteractor)
    : ApiPresenter<KaiYanContract.View>(), KaiYanContract.Presenter {

    override fun onPresenterCreate() {
        super.onPresenterCreate()
        getKaiYanVideo()
    }

    override fun getKaiYanVideo() {
        fetch(kaiYanInteractor.getKaiYanVideo()) {
            view?.hideLoading()
            if (it.isNotEmpty()) {
                view?.shwoVideo(it)
            } else {
                view?.showNoVideo()
            }
        }
    }

    override fun onRequestStart() {
        super.onRequestStart()
        view?.showLoading()
    }
}