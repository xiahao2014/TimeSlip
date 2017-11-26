package com.xia.timeslip.presentation.screen.one

import com.xia.timeslip.domain.entity.Essay
import com.xia.timeslip.domain.entity.ReadDetail
import com.xia.timeslip.presentation.mvp.api.ApiContract

/**
 * Created by xiahao on 2017/11/21.
 */
interface OneContract {

    interface View : ApiContract.View {

        fun oneReadList(listOneRead: List<Essay>?)
        fun showReadDetail(readDetail: ReadDetail?)
        fun showNoRead()

    }

    interface Presenter : ApiContract.Presenter<View> {
        fun getOneReadDetail(content_id: String) //获取阅读详情
    }

}