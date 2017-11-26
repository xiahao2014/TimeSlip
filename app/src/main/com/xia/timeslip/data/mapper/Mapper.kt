package com.xia.timeslip.data.mapper

import com.xia.timeslip.data.response.one.AuthorResponse
import com.xia.timeslip.data.response.one.OneContentBean
import com.xia.timeslip.data.response.one.OneReadBean
import com.xia.timeslip.domain.entity.Author
import com.xia.timeslip.domain.entity.Essay
import com.xia.timeslip.domain.entity.ReadDetail

/**
 * 数据转换及处理相关(过滤掉不需要的数据)
 * Created by user on 2017/11/25.
 */
class Mapper {

    fun translate(oneReadBean: OneReadBean?): List<Essay>? {
        return oneReadBean?.dataResponse?.essayResponse?.
                asSequence()?.map {
            Essay(it.content_id, it.hp_title, it.guide_word,
                    it.hp_makettime, translate(it.authorResponse?.get(0)))
        }?.toList()
    }

    fun translate(author: AuthorResponse?): Author {
        return Author(author?.user_id, author?.user_name,
                author?.desc, author?.fans_total, author?.web_url)
    }

    fun translate(oneContentBean: OneContentBean?): ReadDetail? {
        return oneContentBean?.oneContentResponse?.let {
            ReadDetail(it.hp_title, it.sub_title, it.hp_author, it.hp_author_introduce,
                    it.hp_content, it.hp_makettime, it.web_url, it.praisenum,
                    it.sharenum, it.commentnum)
        }

    }
}