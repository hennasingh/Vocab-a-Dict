package com.coder.vocab.ui.main

import com.coder.vocab.di.ActivityScope
import com.coder.vocab.ui.base.BaseViewModel
import com.coder.vocab.utils.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(compositeDisposable, networkHelper) {

    override fun onCreate() {

    }
}