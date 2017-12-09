package com.xia.timeslip.presentation.screen.kaiyan

import com.xia.timeslip.presentation.mvp.base.BaseFragment
import com.xia.timeslip.presentation.utils.L
import javax.inject.Inject

/**
 *
 * Created by xiahao on 2017/12/4.
 */
class KaiYanFragment : BaseFragment<KaiYanContract.View, KaiYanContract.Presenter>(), KaiYanContract.View {

    @Inject
    protected lateinit var kaiyanPresenter: KaiYanPresenter

    override fun initPresenter() = kaiyanPresenter

    override fun injectDependencies() {
        activityComponent.inject(this)
    }

    override val layoutResId = L.fragment_kaiyan

    override fun getTitle() = "视频"

}