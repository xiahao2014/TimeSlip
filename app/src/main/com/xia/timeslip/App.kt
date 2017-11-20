package com.xia.timeslip

import android.app.Application
import com.luseen.logger.BuildConfig
import com.luseen.logger.LogType
import com.luseen.logger.Logger
import com.xia.timeslip.di.componet.ApplicationComponent
import com.xia.timeslip.di.componet.DaggerApplicationComponent
import com.xia.timeslip.di.module.ApplicationModule
import com.xia.timeslip.presentation.utils.extension.unSafeLazy

/**
 * 初始化化相关
 * Created by user on 2017/11/18.
 */
class App : Application() {

    val applicationComponent: ApplicationComponent by unSafeLazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initLogger()
    }

    private fun initLogger() {
        Logger.Builder()
                .isLoggable(BuildConfig.DEBUG)
                .logType(LogType.ERROR)
                .tag("TimeSlip")
                .setIsKotlin(true)
                .build()
    }

}