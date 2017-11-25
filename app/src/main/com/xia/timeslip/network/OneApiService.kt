package com.xia.timeslip.network

import com.xia.timeslip.data.response.OneReadBean
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Chatikyan on 10.08.2017.
 */
interface OneApiService {


//    @GET("user")
//    fun getUser(): Flowable<UserResponse>

//    @GET("reading/index/?version=3.5.0&platform=android")
//    fun getOneReadingList(): Single<List<OneReadBean>>

    @GET("v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun getOneReadingList(): Observable<List<OneReadBean>>
}