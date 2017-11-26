package com.xia.timeslip.data.response.one

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by user on 2017/11/26.
 */
class OneContentResponse {

    @SerializedName("content_id")
    @Expose
    val content_id: String? = null

    @SerializedName("hp_title")
    @Expose
    val hp_title: String? = null

    @SerializedName("sub_title")
    @Expose
    val sub_title: String? = null

    @SerializedName("hp_author")
    @Expose
    val hp_author: String? = null

    @SerializedName("auth_it")
    @Expose
    val auth_it: String? = null

    @SerializedName("hp_author_introduce")
    @Expose
    val hp_author_introduce: String? = null

    @SerializedName("hp_content")
    @Expose
    val hp_content: String? = null

    @SerializedName("hp_makettime")
    @Expose
    val hp_makettime: String? = null

    @SerializedName("hide_flag")
    @Expose
    val hide_flag: String? = null

    @SerializedName("wb_name")
    @Expose
    val wb_name: String? = null

    @SerializedName("wb_img_url")
    @Expose
    val wb_img_url: String? = null

    @SerializedName("last_update_date")
    @Expose
    val last_update_date: String? = null

    @SerializedName("web_url")
    @Expose
    val web_url: String? = null

    @SerializedName("guide_word")
    @Expose
    val guide_word: String? = null

//    @SerializedName("audio")
//    @Expose
//    val audio: String? = null
//
//    @SerializedName("anchor")
//    @Expose
//    val anchor: String? = null

    @SerializedName("editor_email")
    @Expose
    val editor_email: String? = null

//    @SerializedName("top_media_type")
//    @Expose
//    val top_media_type: String? = null
//
//    @SerializedName("top_media_file")
//    @Expose
//    val top_media_file: String? = null
//
//    @SerializedName("top_media_image")
//    @Expose
//    val top_media_image: String? = null

    @SerializedName("praisenum")
    @Expose
    val praisenum: Int? = null

    @SerializedName("sharenum")
    @Expose
    val sharenum: Int? = null

    @SerializedName("commentnum")
    @Expose
    val commentnum: Int? = null
}