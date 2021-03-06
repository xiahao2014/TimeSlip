package com.xia.timeslip.data.response.kaiyan

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by user on 2017/12/9.
 */
class KaiyaiAuthorResponse {

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null
}