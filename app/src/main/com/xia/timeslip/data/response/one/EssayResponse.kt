package com.xia.timeslip.data.response.one

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by user on 2017/11/25.
 */
class EssayResponse {

    @SerializedName("content_id")
    @Expose
    val content_id: String? = null

    @SerializedName("hp_title")
    @Expose
    val hp_title: String? = null

    @SerializedName("hp_makettime")
    @Expose
    val hp_makettime: String? = null

    @SerializedName("guide_word")
    @Expose
    val guide_word: String? = null

    @SerializedName("start_video")
    @Expose
    val start_video: String? = null

    @SerializedName("author")
    @Expose
    val authorResponse: List<AuthorResponse>? = null

    @SerializedName("has_audio")
    @Expose
    val has_audio: Boolean? = null

    @SerializedName("author_list")
    @Expose
    val author_list: List<AuthorResponse>? = null

}