package com.xia.timeslip.domain.repository

import com.xia.timeslip.domain.entity.KaiYan
import io.reactivex.Flowable

/**
 * Created by user on 2017/12/9.
 */
interface KaiYanRspository {

    fun getKaiYanVideo(): Flowable<List<KaiYan>>
}