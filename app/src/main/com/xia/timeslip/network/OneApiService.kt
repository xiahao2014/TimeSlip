package com.xia.timeslip.network

import com.xia.timeslip.data.response.one.OneContentBean
import com.xia.timeslip.data.response.one.OneReadBean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Chatikyan on 10.08.2017.
 */
interface OneApiService {


//    @GET("user")
//    fun getUser(): Flowable<UserResponse>

    @GET("reading/index/?version=3.5.0&platform=android")
    fun getOneReadingList(): Flowable<OneReadBean>

    //    http://v3.wufazhuce.com:8000/api/essay/2930?channel=wdj&source=summary&source_id=9245&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    @GET("essay/{content_id}?channel=wdj&source=summary&source_id=9245&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
    fun getOneReadDetail(@Path("content_id") content_id: String): Flowable<OneContentBean>
}