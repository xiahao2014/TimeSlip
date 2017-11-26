package com.xia.timeslip.presentation.screen.one

import android.os.Bundle
import android.view.View
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
class OneFragment : BaseFragment<OneContract.View, OneContract.Presenter>(), OneContract.View {

    @Inject
    protected lateinit var oneReadPresenter: OnePresenter


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar.backgroundCircleColor = takeColor(C.colorPrimary)
        RichText.initCacheDir(context)
        RichText.debugMode = true


    }

    override fun injectDependencies() {
        activityComponent.inject(this)
    }

    override fun initPresenter() = oneReadPresenter

    override val layoutResId = L.fragment_one_list


    override fun oneReadList(listOneRead: List<Essay>?) {

    }

    override fun showReadDetail(readDetail: ReadDetail?) {
        RichText.fromHtml(readDetail!!.hp_content).into(html)
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

}