package com.xia.timeslip.di.componet

import com.xia.timeslip.di.module.ActivityModule
import com.xia.timeslip.di.scope.PerActivity
import com.xia.timeslip.presentation.screen.home.HomeActivity
import com.xia.timeslip.presentation.screen.kaiyan.KaiYanFragment
import com.xia.timeslip.presentation.screen.one.OneFragment
import dagger.Subcomponent

/**
 * Created by user on 2017/11/18.
 */

@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(homeActivity: HomeActivity)
    fun inject(oneFragment: OneFragment)
    fun inject(kaiYanFragment: KaiYanFragment)
}