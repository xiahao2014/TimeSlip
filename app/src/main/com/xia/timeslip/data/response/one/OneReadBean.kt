package com.xia.timeslip.data.response.one

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by user on 2017/11/25.
 */
class OneReadBean {

    @SerializedName("res")
    @Expose
    val res: Int? = null

    @SerializedName("data")
    @Expose
    val dataResponse: DataResponse? = null
}