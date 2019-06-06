package com.coder.vocab.di.module

import com.coder.vocab.*
import com.coder.vocab.network.OxfordApi
import com.coder.vocab.utils.network.NetworkHelper
import com.coder.vocab.utils.rx.RxSchedulerProvider
import com.coder.vocab.utils.rx.SchedulerProvider
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: OxfordApplication) {

    @Provides
    @Singleton
    fun provideInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }

    /**
     * Since this function do not have @Singleton then each time CompositeDisposable is injected
     * then a new instance of CompositeDisposable will be provided
     */
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor {
                it.proceed(
                    it.request()
                        .newBuilder()
                        .addHeader("app_id", APP_ID)
                        .addHeader("app_key", APP_KEY)
                        .build()
                )
            }
            .build()

    @Provides
    @Singleton
    fun provideOxfordApi(client: OkHttpClient): OxfordApi =
        Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(OxfordApi::class.java)


    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper =
        NetworkHelper(application)


}