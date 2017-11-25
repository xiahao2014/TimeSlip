package com.xia.timeslip.domain.interactor

import com.xia.timeslip.data.repository.OneDataRepository
import com.xia.timeslip.data.response.OneReadBean
import io.reactivex.Observable
import javax.inject.Inject

/**
 * 对数据进行二次封装或者其他操作
 * Created by user on 2017/11/19.
 */
class OneInteractor @Inject constructor(private val oneDataRepository: OneDataRepository) {

    //对数据在进行处理
//    fun getUser(code: String): Flowable<User> {
//        return userDataRepository.getToken(code)//根据code请求接口获取token
//                .doOnNext { preferences saveUserToken it.token }//保持token到preferences
//                .flatMap { userDataRepository.getUser() }//请求接口，获取用户信息
//                .doOnNext { userDataRepository.logIn() }//保存登录状态
//    }

    fun getAndroidData(): Observable<List<OneReadBean>> = oneDataRepository.getOneReadingList()
}