package com.xia.timeslip.data.response.one

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by user on 2017/11/25.
 */
class QuestionResponse {

    @SerializedName("question_id")
    @Expose
    val question_id: String? = null

    @SerializedName("question_title_id")
    @Expose
    val question_title: String? = null

    @SerializedName("answer_title")
    @Expose
    val answer_title: String? = null

    @SerializedName("answer_content")
    @Expose
    val answer_content: String? = null

    @SerializedName("question_makettime")
    @Expose
    val question_makettime: String? = null

    @SerializedName("start_video")
    @Expose
    val start_video: String? = null

    @SerializedName("author_list")
    @Expose
    val author_list: List<AuthorResponse>? = null

    @SerializedName("asker_list")
    @Expose
    val asker_list: List<AuthorResponse>? = null
}