package com.xia.timeslip.presentation.screen.home


import android.support.v4.app.Fragment
import com.xia.timeslip.di.scope.PerActivity
import com.xia.timeslip.presentation.mvp.api.ApiPresenter
import com.xia.timeslip.presentation.mvp.base.BaseFragment
import com.xia.timeslip.presentation.utils.extension.emptyString
import javax.inject.Inject

/**
 * 主页实现
 * Created by Chatikyan on 31.07.2017.
 */
@PerActivity
class HomePresenter @Inject constructor()
    : ApiPresenter<HomeContract.View>(), HomeContract.Presenter {

    override fun onPresenterCreate() {
        super.onPresenterCreate()
        view?.openOneFragment()
    }


    override fun handleFragmentChanges(currentTag: String, fragment: Fragment) {

        val tag = if (fragment is BaseFragment<*, *>) {
            fragment.getTitle()
        } else {
            emptyString
        }
        view?.setToolBarTitle(tag)
    }
}