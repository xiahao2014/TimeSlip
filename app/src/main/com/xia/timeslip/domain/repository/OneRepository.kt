package com.xia.timeslip.domain.repository

import com.xia.timeslip.domain.entity.Essay
import com.xia.timeslip.domain.entity.ReadDetail
import io.reactivex.Flowable

/**
 * 定义操作的接口
 * Created by user on 2017/11/25.
 */
interface OneRepository {

    fun getEssayList(): Flowable<List<Essay>>
    fun getReadDetail(content_id:String): Flowable<ReadDetail>
}