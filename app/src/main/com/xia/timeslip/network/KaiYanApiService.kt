package com.xia.timeslip.network

import com.xia.timeslip.data.response.kaiyan.KaiYanBean
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * Created by Chatikyan on 29.07.2017.
 */
interface KaiYanApiService {

    @GET("tabs/selected")
    fun getkaiYanVideo(): Flowable<KaiYanBean>

}