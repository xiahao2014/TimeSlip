package com.xia.timeslip.data.response.kaiyan

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by user on 2017/12/9.
 */
class ItemListResponse {


    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("data")
    @Expose
    var dataResponse: DataResponse? = null

}