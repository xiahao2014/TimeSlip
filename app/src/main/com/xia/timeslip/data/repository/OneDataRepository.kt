package com.xia.timeslip.data.repository


import com.xia.timeslip.data.mapper.Mapper
import com.xia.timeslip.di.scope.PerActivity
import com.xia.timeslip.domain.entity.Essay
import com.xia.timeslip.domain.entity.ReadDetail
import com.xia.timeslip.domain.repository.OneRepository
import com.xia.timeslip.network.OneApiService
import io.reactivex.Flowable
import javax.inject.Inject


/**
 * 负责请求接口并对需要的数据进行处理
 */
@PerActivity
class OneDataRepository @Inject constructor(
        private val oneApiService: OneApiService,
        private val mapper: Mapper) : OneRepository {


    override fun getEssayList(): Flowable<List<Essay>> {
        return oneApiService.getOneReadingList().map {
            mapper.translate(it)
        }
    }

    override fun getReadDetail(content_id: String): Flowable<ReadDetail> {
        return oneApiService.getOneReadDetail(content_id).map {
            mapper.translate(it)
        }
    }

    //请求接口并处理数据在返回
//    override fun getUser(): Flowable<User> {
//        //请求接口获取--Flowable<UserResponse>
//        return userApiService.getUser().map {
//            mapper.translate(it)//将接口返回的数据，组装user数据，返回Flowable<User>
//        }
//    }
}