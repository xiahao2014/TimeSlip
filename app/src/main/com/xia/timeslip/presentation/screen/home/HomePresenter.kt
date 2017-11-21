package com.xia.timeslip.presentation.screen.home


import com.xia.timeslip.di.scope.PerActivity
import com.xia.timeslip.domain.interactor.OneInteractor
import com.xia.timeslip.presentation.mvp.api.ApiPresenter
import javax.inject.Inject

/**
 * 主页实现
 * Created by Chatikyan on 31.07.2017.
 */
@PerActivity
class HomePresenter @Inject constructor(private val oneInteractor: OneInteractor)
    : ApiPresenter<HomeContract.View>(), HomeContract.Presenter {

    override fun onPresenterCreate() {
        super.onPresenterCreate()
        view?.openOneFragment()
    }
}