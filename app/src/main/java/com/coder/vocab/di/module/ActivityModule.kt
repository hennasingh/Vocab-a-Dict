package com.coder.vocab.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.coder.vocab.di.ActivityContext
import com.coder.vocab.ui.base.BaseActivity
import com.coder.vocab.ui.main.MainViewModel
import com.coder.vocab.utils.ViewModelProviderFactory
import com.coder.vocab.utils.network.NetworkHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = activity

    @Provides
    fun provideMainViewModel(
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): MainViewModel = ViewModelProviders.of(activity, ViewModelProviderFactory(MainViewModel::class) {
        MainViewModel(compositeDisposable, networkHelper)
    }).get(MainViewModel::class.java)
}