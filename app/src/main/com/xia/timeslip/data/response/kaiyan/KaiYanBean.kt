package com.xia.timeslip.data.response.kaiyan

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by user on 2017/12/9.
 */
class KaiYanBean {


    @SerializedName("itemList")
    @Expose
    var itemListResponse: List<ItemListResponse>? = null

    @SerializedName("nextPageUrl")
    @Expose
    var nextPageUrl: String? = null

    @SerializedName("date")
    @Expose
    var date: Long? = null

    @SerializedName("nextPublishTime")
    @Expose
    var nextPublishTime: Long? = null
}