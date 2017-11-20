package com.xia.timeslip.presentation.screen.home

import android.os.Bundle
import com.xia.timeslip.data.response.FuckGoods
import com.xia.timeslip.presentation.mvp.base.BaseActivity
import news.xia.com.timeslip.R
import javax.inject.Inject

class HomeActivity : BaseActivity<HomeContract.View, HomeContract.Presenter>(), HomeContract.View {


    @Inject
    protected lateinit var homePresenter: HomePresenter

    override fun initPresenter() = homePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun injectDependencies() {
        activityComponent.inject(this)
    }

    override fun onDataReceive(fuckGoods: List<FuckGoods>) {
//            log(f)
        println(fuckGoods[0]._id)
    }

    override fun showNoShots() {
    }
}
