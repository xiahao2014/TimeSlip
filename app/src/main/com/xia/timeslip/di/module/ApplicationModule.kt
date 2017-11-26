package com.xia.timeslip.di.module

import android.app.Application
import com.xia.timeslip.data.mapper.Mapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Chatikyan on 29.07.2017.
 */
@Module
class ApplicationModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideApplication(): Application = application

    @Singleton
    @Provides
    fun provideMapper(): Mapper = Mapper()
}