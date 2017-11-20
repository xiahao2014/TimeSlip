package com.xia.timeslip.data.cache

import android.util.LruCache
import com.xia.timeslip.domain.result_listener.RequestType
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Chatikyan on 26.09.2017.
 */
@Singleton
class MemoryCache @Inject constructor() : LruCache<RequestType, Any>(1024 * 1024 * 2)/* 2 MB */ {

    inline infix fun <reified V> getCacheForType(key: RequestType) = get(key) as V
}