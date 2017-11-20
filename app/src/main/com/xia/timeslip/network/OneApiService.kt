package com.xia.timeslip.network

import com.xia.timeslip.data.response.FuckGoods
import com.xia.timeslip.data.response.JsonResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Chatikyan on 10.08.2017.
 */
interface OneApiService {


//    @GET("user")
//    fun getUser(): Flowable<UserResponse>

    @GET("data/Android/10/{page}")
    fun getAndroidData(@Path("page") page: Int): Observable<JsonResult<List<FuckGoods>>>

}