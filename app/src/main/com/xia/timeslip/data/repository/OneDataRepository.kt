package com.xia.timeslip.data.repository


import com.xia.timeslip.di.scope.PerActivity
import com.xia.timeslip.network.OneApiService
import javax.inject.Inject


/**
 * 负责请求接口及处理数据相关
 * Created by Chatikyan on 10.08.2017.
 */
@PerActivity
class OneDataRepository @Inject constructor(
        private val oneApiService: OneApiService) {

    //请求接口并处理数据在返回
//    override fun getUser(): Flowable<User> {
//        //请求接口获取--Flowable<UserResponse>
//        return userApiService.getUser().map {
//            mapper.translate(it)//将接口返回的数据，组装user数据，返回Flowable<User>
//        }
//    }


    //请求接口，返回Flowable<TokenResponse>
    fun getAndroidData(page: Int) = oneApiService.getAndroidData(page)

}