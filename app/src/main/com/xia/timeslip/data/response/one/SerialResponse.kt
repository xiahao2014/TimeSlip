package com.xia.timeslip.data.response.one

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by user on 2017/11/25.
 */
class SerialResponse {

    @SerializedName("id")
    @Expose
    val id: String? = null

    @SerializedName("serial_id")
    @Expose
    val serial_id: String? = null

    @SerializedName("number")
    @Expose
    val number: String? = null

    @SerializedName("title")
    @Expose
    val title: String? = null

    @SerializedName("excerpt")
    @Expose
    val excerpt: String? = null

    @SerializedName("read_num")
    @Expose
    val read_num: String? = null

    @SerializedName("maketime")
    @Expose
    val maketime: String? = null

    @SerializedName("start_video")
    @Expose
    val start_video: String? = null

    @SerializedName("author")
    @Expose
    val author: AuthorResponse? = null

    @SerializedName("has_audio")
    @Expose
    val has_audio: Boolean? = null

    @SerializedName("author_list")
    @Expose
    val author_list: List<AuthorResponse>? = null

    @SerializedName("serial_list")
    @Expose
    val serial_list: List<String>? = null
}