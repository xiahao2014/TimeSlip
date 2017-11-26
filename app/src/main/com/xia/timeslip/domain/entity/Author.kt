package com.xia.timeslip.domain.entity

/**
 * Created by user on 2017/11/25.
 */
data class Author(var user_id: String?, var user_name: String?, var desc: String?, var fans_total: String?,
                  var web_url: String?) {

//    val commentDate = "${format("dd")} ${format("MMM")} ${format("HH:mm")}"
//    private fun format(pattern: String) = SimpleDateFormat(pattern, Locale.ENGLISH).format(date)
}