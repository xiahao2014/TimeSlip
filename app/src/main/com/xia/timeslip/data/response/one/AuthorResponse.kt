package com.xia.timeslip.data.response.one

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by user on 2017/11/25.
 */
class AuthorResponse {

    @SerializedName("user_id")
    @Expose
    val user_id: String? = null

    @SerializedName("user_name")
    @Expose
    val user_name: String? = null

    @SerializedName("desc")
    @Expose
    val desc: String? = null

    @SerializedName("wb_name")
    @Expose
    val wb_name: String? = null

    @SerializedName("is_settled")
    @Expose
    val is_settled: String? = null

    @SerializedName("settled_type")
    @Expose
    val settled_type: String? = null

    @SerializedName("summary")
    @Expose
    val summary: String? = null

    @SerializedName("fans_total")
    @Expose
    val fans_total: String? = null

    @SerializedName("web_url")
    @Expose
    val web_url: String? = null
}