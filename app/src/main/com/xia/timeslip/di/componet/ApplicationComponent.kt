package com.xia.timeslip.di.componet


import dagger.Component
import com.xia.timeslip.di.module.ActivityModule
import com.xia.timeslip.di.module.ApiModule
import com.xia.timeslip.di.module.ApplicationModule
import javax.inject.Singleton

/**
 * Created by Chatikyan on 29.07.2017.
 */
@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        ApiModule::class))
interface ApplicationComponent {

    fun plus(activityModule: ActivityModule): ActivityComponent
}