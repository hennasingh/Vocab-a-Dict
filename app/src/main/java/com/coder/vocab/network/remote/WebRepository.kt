package com.coder.vocab.network.remote

import androidx.lifecycle.MutableLiveData
import com.coder.vocab.model.BaseResult
import com.coder.vocab.model.DisplayWordData
import com.coder.vocab.network.ApiManager
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject

class WebRepository @Inject constructor(private val apiManager: ApiManager) {

    internal val TAG = WebRepository::class.java.simpleName

    internal val wordMutableData: MutableLiveData<List<DisplayWordData>> = MutableLiveData()


    fun getDictionaryResult(lang: String, word: String) {
        val wordData: Observable<BaseResult> = apiManager.getDictionaryResults(lang, word)
        wordData.subscribeOn(Schedulers.io())
            .retry(2)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<BaseResult>() {
                override fun onComplete() {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onNext(baseResult: BaseResult) {

                }

                override fun onError(e: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
    }
}