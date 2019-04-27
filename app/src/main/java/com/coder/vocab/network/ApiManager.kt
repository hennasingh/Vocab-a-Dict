package com.coder.vocab.network

import com.coder.vocab.model.BaseResult
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import javax.inject.Inject

class ApiManager @Inject constructor(private val apiService: OxfordApi) {


    fun getDictionaryResults(
        lang: String,
        word: String
    ): Observable<BaseResult> = apiService.getDictionaryResult(lang, word)


}