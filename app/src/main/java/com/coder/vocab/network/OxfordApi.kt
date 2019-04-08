package com.coder.vocab.network

import com.coder.vocab.model.BaseResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface OxfordApi {

    @GET("entries/{lang}/{word}")
    fun getDictionaryResult(
        @Path("lang") lang: String,
        @Path("word") word: String
    ): Call<BaseResult>

}