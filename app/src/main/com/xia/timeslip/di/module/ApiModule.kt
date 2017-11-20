package com.xia.timeslip.di.module


import com.xia.timeslip.network.ApiConstants
import com.xia.timeslip.network.EyepetizerApiService
import com.xia.timeslip.network.OneApiService
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import news.xia.com.timeslip.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 *
 * Created by Chatikyan on 04.08.2017.
 */
@Module
class ApiModule {

    @Singleton
    @Provides
    @Named("OneEndpoint")
    fun shotEndpoint(): String {
        return ApiConstants.ONE_LIST
    }

    @Singleton
    @Provides
    @Named("EyepetizerEndpoint")
    fun authEndpoint() = ApiConstants.KAI_YAN

    @Singleton
    @Provides
    fun provideOkHttpBuilder(): OkHttpClient.Builder {
        val okHttpBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BASIC
            okHttpBuilder.addInterceptor(logging)
        }
        okHttpBuilder.readTimeout(15.toLong(), TimeUnit.SECONDS)
        okHttpBuilder.connectTimeout(15.toLong(), TimeUnit.SECONDS)
        return okHttpBuilder
    }

    @Singleton
    @Provides
    @Named("OneRetrofit")
    fun provideOneRetrofit(retrofitBuilder: Retrofit.Builder,
                           okHttpClientBuilder: OkHttpClient.Builder,
                           @Named("OneEndpoint") baseUrl: String): Retrofit {
        return retrofitBuilder
                .client(okHttpClientBuilder.build())
                .baseUrl(baseUrl)
                .build()
    }


    @Singleton
    @Provides
    @Named("EyepetizerRetrofit")
    fun provideEyepetizerRetrofit(retrofitBuilder: Retrofit.Builder,
                                  okHttpClientBuilder: OkHttpClient.Builder,
                                  @Named("EyepetizerEndpoint") baseUrl: String): Retrofit {
        return retrofitBuilder
                .client(okHttpClientBuilder.build())
                .baseUrl(baseUrl)
                .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    @Singleton
    @Provides
    fun provideOneService(@Named("OneRetrofit") retrofit: Retrofit): OneApiService {
        return retrofit.create(OneApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideEyepetizerApiService(@Named("EyepetizerRetrofit") retrofit: Retrofit): EyepetizerApiService {
        return retrofit.create(EyepetizerApiService::class.java)
    }


    @Singleton
    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()
}