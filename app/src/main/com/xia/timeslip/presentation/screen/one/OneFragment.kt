package com.xia.timeslip.presentation.screen.one

import android.os.Bundle
import android.support.v4.widget.NestedScrollView
import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import android.widget.Toast
import com.xia.timeslip.domain.entity.Essay
import com.xia.timeslip.domain.entity.ReadDetail
import com.xia.timeslip.presentation.mvp.base.BaseFragment
import com.xia.timeslip.presentation.utils.C
import com.xia.timeslip.presentation.utils.L
import com.xia.timeslip.presentation.utils.extension.takeColor
import com.zzhoujay.richtext.RichText
import kotlinx.android.synthetic.main.fragment_one_list.*
import kotlinx.android.synthetic.main.progress_bar.*
import javax.inject.Inject


/**
 * one detail
 * Created by xiahao on 2017/11/21.
 */
class OneFragment : BaseFragment<OneContract.View, OneContract.Presenter>(), OneContract.View, SwipeRefreshLayout.OnRefreshListener {

    var content_id = arrayListOf<String>()
    private var reuqest_id: Int = 1

    @Inject
    protected lateinit var oneReadPresenter: OnePresenter

    /**
     * 最小的滑动距离
     */
    private val SCROLLLIMIT = 40

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar.backgroundCircleColor = takeColor(C.colorPrimary)
        RichText.initCacheDir(context)
        RichText.debugMode = true
        refreshLayout.setOnRefreshListener(this)
        refreshLayout.setColorSchemeColors(takeColor(C.colorPrimary), takeColor(C.colorPrimary))

        fab_top.setOnClickListener {
            scroll.scrollTo(0, 0)
            fab_top.visibility = View.GONE
        }
        scroll.setOnScrollChangeListener { _: NestedScrollView?, _: Int, scrollY: Int, _: Int, oldScrollY: Int ->
            if (oldScrollY > scrollY && oldScrollY - scrollY > SCROLLLIMIT) {// 向下
                if (fab_top.visibility == View.GONE)
                    fab_top.visibility = View.VISIBLE
            } else if (oldScrollY < scrollY && scrollY - oldScrollY > SCROLLLIMIT) {// 向上
                if (fab_top.visibility == View.VISIBLE)
                    fab_top.visibility = View.GONE
            }
        }
    }

    override fun injectDependencies() {
        activityComponent.inject(this)
    }

    override fun initPresenter() = oneReadPresenter

    override val layoutResId = L.fragment_one_list


    override fun oneReadList(listOneRead: List<Essay>?) {
        listOneRead?.forEachIndexed { index, value
            ->
            content_id.add(index, value.content_id.toString())
        }
    }

    override fun showReadDetail(readDetail: ReadDetail?) {
        read_title.text = readDetail?.hp_title
        if (!readDetail?.hp_author.isNullOrEmpty()) {
            read_auther.text = "文/" + readDetail?.hp_author
        } else {
            read_auther.visibility = View.GONE
        }
        RichText.from(readDetail?.hp_content)
                .noImage(true) // 不显示并且不加载图片
                .into(read_content)
        refreshLayout.isRefreshing = false
    }


    override fun onRefresh() {
        progressBar.visibility = View.GONE
        if (content_id.size > reuqest_id) {
            oneReadPresenter.getOneReadDetail(content_id[reuqest_id])
            reuqest_id++
        } else {
            Toast.makeText(context, "没有了(⊙o⊙)", Toast.LENGTH_SHORT).show()
            refreshLayout.isRefreshing = false
        }
    }

    override fun showNoRead() {
    }


    override fun showLoading() {
        progressBar.start()
    }

    override fun hideLoading() {
        progressBar.stop()
    }

    override fun showError(message: String?) {
        showErrorDialog(message)
    }

    override fun getTitle() = "阅读"

}