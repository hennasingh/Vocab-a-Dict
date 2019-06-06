package com.coder.vocab.di.component

import com.coder.vocab.OxfordApplication
import com.coder.vocab.di.module.ApplicationModule
import com.coder.vocab.network.OxfordApi
import com.coder.vocab.utils.network.NetworkHelper
import com.coder.vocab.utils.rx.SchedulerProvider
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: OxfordApplication)

    fun getOxfordApi(): OxfordApi

    fun getSchedulerProvider(): SchedulerProvider

    fun getCompositeDisposable(): CompositeDisposable

    fun getNetworkHelper(): NetworkHelper
}