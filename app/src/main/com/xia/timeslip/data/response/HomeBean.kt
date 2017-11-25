package com.xia.timeslip.data.response

import com.google.gson.annotations.SerializedName

/**
 * Created by xiahao on 2017/11/24.
 */
data class HomeBean(@SerializedName("nextPageUrl") var nextPageUrl: String?,
                    @SerializedName("nextPublishTime") var nextPublishTime: Long,
                    @SerializedName("newestIssueType") var newestIssueType: String?,
                    @SerializedName("dialog") var dialog: Any?,
                    @SerializedName("issueList") var issueList: List<IssueListBean>?) {

    data class IssueListBean(@SerializedName("releaseTime") var releaseTime: Long,
                             @SerializedName("type") var type: String?,
                             @SerializedName("date") var date: Long,
                             @SerializedName("publishTime") var publishTime: Long,
                             @SerializedName("count") var count: Int,
                             @SerializedName("itemList") var itemList: List<ItemListBean>?) {

        data class ItemListBean(@SerializedName("type") var type: String?,
                                @SerializedName("data") var data: DataBean?,
                                @SerializedName("tag") var tag: Any?) {

            data class DataBean(@SerializedName("dataType") var dataType: String?,
                                @SerializedName("id") var id: Int,
                                @SerializedName("title") var title: String?,
                                @SerializedName("description") var description: String?,
                                @SerializedName("image") var image: String?,
                                @SerializedName("actionUrl") var actionUrl: String?,
                                @SerializedName("adTrack") var adTrack: Any?,
                                @SerializedName("isShade") var isShade: Boolean,
                                @SerializedName("label") var label: Any?,
                                @SerializedName("labelList") var labelList: Any?,
                                @SerializedName("header") var header: Any?,
                                @SerializedName("category") var category: String?,
                                @SerializedName("duration") var duration: Long?,
                                @SerializedName("playUrl") var playUrl: String,
                                @SerializedName("cover") var cover: CoverBean?,
                                @SerializedName("author") var author: AuthorBean?,
                                @SerializedName("releaseTime") var releaseTime: Long?,
                                @SerializedName("consumption") var consumption: ConsumptionBean?) {
                data class CoverBean(@SerializedName("feed") var feed: String?,
                                     @SerializedName("detail") var detail: String?,
                                     @SerializedName("blurred") var blurred: String?,
                                     @SerializedName("sharing") var sharing: String?,
                                     @SerializedName("homepage") var homepage: String?) {}

                data class ConsumptionBean(@SerializedName("collectionCount") var collectionCount: Int,
                                           @SerializedName("shareCount") var shareCount: Int,
                                           @SerializedName("replyCount") var replyCount: Int) {
                }

                data class AuthorBean(@SerializedName("icon") var icon: String) {}
            }
        }
    }
}