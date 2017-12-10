package com.xia.timeslip.data.response.kaiyan

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by user on 2017/12/9.
 */
class DataResponse {

    @SerializedName("dataType")
    @Expose
    var dataType: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("slogan")
    @Expose
    var slogan: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("category")
    @Expose
    var category: String? = null

    @SerializedName("author")
    @Expose
    var authotResponse: KaiyaiAuthorResponse? = null

    @SerializedName("playUrl")
    @Expose
    var playUrl: String? = null

    @SerializedName("duration")
    @Expose
    var duration: Int? = null

    @SerializedName("date")
    @Expose
    var date: Long? = null
}