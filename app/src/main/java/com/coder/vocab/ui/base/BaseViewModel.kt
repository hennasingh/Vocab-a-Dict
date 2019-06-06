package com.coder.vocab.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coder.vocab.utils.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(
    protected val compositeDisposable: CompositeDisposable,
    protected val networkHelper: NetworkHelper
) : ViewModel() {

    val messageStringId = MutableLiveData<Int>()
    val messageString = MutableLiveData<String>()

    protected fun checkInternetConnection(): Boolean = networkHelper.isNetworkConnected()

    protected fun handleNetworkError(err: Throwable) {
        //handle the error
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    abstract fun onCreate()
}