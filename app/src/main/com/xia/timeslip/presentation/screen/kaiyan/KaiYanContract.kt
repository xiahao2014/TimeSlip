package com.xia.timeslip.presentation.screen.kaiyan

import com.xia.timeslip.domain.entity.KaiYan
import com.xia.timeslip.presentation.mvp.api.ApiContract

/**
 * Created by xiahao on 2017/11/21.
 */
interface KaiYanContract {

    interface View : ApiContract.View {

        fun shwoVideo(kaiyan: List<KaiYan>)
        fun showNoVideo()

    }

    interface Presenter : ApiContract.Presenter<View> {

        fun getKaiYanVideo()
    }

}