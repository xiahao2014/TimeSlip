package com.xia.timeslip.presentation.screen.home

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.xia.timeslip.presentation.mvp.base.BaseActivity
import com.xia.timeslip.presentation.screen.one.OneFragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_main.*
import news.xia.com.timeslip.R
import javax.inject.Inject

class HomeActivity : BaseActivity<HomeContract.View, HomeContract.Presenter>(), HomeContract.View, NavigationView.OnNavigationItemSelectedListener {


    @Inject
    protected lateinit var homePresenter: HomePresenter


    override fun initPresenter() = homePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
//        replaceFragment(FragmentRecyclerView())

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun injectDependencies() {
        activityComponent.inject(this)
    }


    override fun onBackPressed() {
        when {
            drawer_layout.isDrawerOpen(GravityCompat.START) -> drawer_layout.closeDrawer(GravityCompat.START)
            else -> super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }


    override fun openOneFragment() {
        goTo<OneFragment>()
    }

}
