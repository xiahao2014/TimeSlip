package com.xia.timeslip.data.response.one

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by user on 2017/11/25.
 */
class DataResponse {

    @SerializedName("essay")
    @Expose
    val essayResponse: List<EssayResponse>? = null

    @SerializedName("serial")
    @Expose
    val serialResponse: List<SerialResponse>? = null

    @SerializedName("question")
    @Expose
    val questionResponse: List<QuestionResponse>? = null
}