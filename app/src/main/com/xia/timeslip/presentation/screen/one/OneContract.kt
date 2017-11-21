package com.xia.timeslip.presentation.screen.one

import com.xia.timeslip.data.response.FuckGoods
import com.xia.timeslip.presentation.mvp.api.ApiContract

/**
 * Created by xiahao on 2017/11/21.
 */
interface OneContract {

    interface View : ApiContract.View {

        fun oneReadList(listOneRead: List<FuckGoods>)
        fun showNoRead()

    }

    interface Presenter : ApiContract.Presenter<View>

}