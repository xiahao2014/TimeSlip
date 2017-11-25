package com.xia.timeslip.data.response

/**
 * Created by xiahao on 2017/11/23.
 */
data class OneReadBean(var res: Int, var dateBean: DataBean?) {

    data class DataBean(var essay: List<EssayBean>?, var serial: List<SerialBean>?,
                        var question: List<QuestionBean>?) {

        data class EssayBean(var content_id: String, var hp_title: String, var hp_makettime: String,
                             var guide_word: String, var start_video: String?,
                             var author: List<AuthorBean>?, var has_audio: Boolean,
                             var author_List: List<AuthorBean>?) {
            data class AuthorBean(var user_id: String, var user_name: String,
                                  var web_url: String?, var summary: String, var desc: String?,
                                  var is_settled: String?, var settled_type: String?,
                                  var fans_total: String?, var wb_name: String?) {}
        }

        data class SerialBean(var id: String, var serial_id: String,
                              var number: String, var title: String,
                              var excerpt: String, var read_num: String,
                              var maketime: String, var start_video: String?,
                              var author: List<EssayBean.AuthorBean>?, var has_audio: Boolean,
                              var author_List: List<EssayBean.AuthorBean>?,
                              var serial_list: List<String>?)

        data class QuestionBean(var question_id: String, var question_title: String,
                                var answer_title: String?, var answer_content: String,
                                var question_makettime: String, var start_video: String?,
                                var author_List: List<EssayBean.AuthorBean>,
                                var asker_list: List<AskerBean>) {
            data class AskerBean(var user_id: String, var user_name: String,
                                 var web_url: String?, var summary: String?,
                                 var desc: String?, var is_settled: String?,
                                 var settled_type: String?, var fans_total: String?,
                                 var wb_name: String?)
        }
    }
}
