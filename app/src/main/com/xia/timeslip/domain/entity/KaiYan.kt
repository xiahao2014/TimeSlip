package com.xia.timeslip.domain.entity

import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by user on 2017/12/9.
 */
data class KaiYan(var title: String?, var slogan: String?, var description: String?,
                  var category: String?, var author: KaiYanAuthor?, var playUrl: String?,
                  var duration: Int?, var date: Long?) {

    val videDate = format(date)
    private fun format(timeInMillis: Long?): String? {
        val cal = Calendar.getInstance()
        cal.timeInMillis = timeInMillis!!
        val date = cal.time
        return SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(date)
    }
}