package com.coder.vocab.network

import com.coder.vocab.model.BaseResult
import retrofit2.Call
import retrofit2.Callback
import javax.inject.Inject

class ApiManager @Inject constructor(private val apiService: OxfordApi) {


    fun getDictionaryResults(
        lang: String,
        word: String,
        callback: Callback<BaseResult>
    ) {
        val resultCall: Call<BaseResult> = apiService.getDictionaryResult(lang, word)
        resultCall.enqueue(callback)
    }


}