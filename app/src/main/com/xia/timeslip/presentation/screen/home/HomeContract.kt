package com.xia.timeslip.presentation.screen.home

import com.xia.timeslip.data.response.FuckGoods
import com.xia.timeslip.presentation.mvp.api.ApiContract

/**
 * Created by Chatikyan on 31.07.2017.
 */
interface HomeContract {

    interface View : ApiContract.View {

        fun onDataReceive(fuckGoods: List<FuckGoods>)

        fun showNoShots()
    }


    interface Presenter : ApiContract.Presenter<View>

}


