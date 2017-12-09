package com.xia.timeslip.presentation.screen.home

import android.support.v4.app.Fragment
import com.xia.timeslip.presentation.mvp.api.ApiContract

/**
 * Created by Chatikyan on 31.07.2017.
 */
interface HomeContract {

    interface View : ApiContract.View {

        fun openOneFragment()

        fun setToolBarTitle(title: String)
    }


    interface Presenter : ApiContract.Presenter<View> {
        fun handleFragmentChanges(currentTag: String, fragment: Fragment)
    }

}


