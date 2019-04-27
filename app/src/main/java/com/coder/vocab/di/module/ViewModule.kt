package com.coder.vocab.di.module

import com.coder.vocab.di.scope.ViewScope
import com.coder.vocab.network.ApiManager
import com.coder.vocab.network.OxfordApi
import com.coder.vocab.network.remote.WebRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [OxfordApiModule::class])
class ViewModule {

    @Provides
    @ViewScope
    fun provideOxfordApi(retrofit: Retrofit): OxfordApi = retrofit.create(OxfordApi::class.java)

    @Provides
    @ViewScope
    fun provideApiManager(oxfordApi: OxfordApi) = ApiManager(oxfordApi)


    @Provides
    @ViewScope
    fun provideWebRepo(apiManager: ApiManager) = WebRepository(apiManager)
}