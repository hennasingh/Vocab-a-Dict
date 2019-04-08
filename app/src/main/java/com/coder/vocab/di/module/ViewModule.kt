package com.coder.vocab.di.module

import com.coder.vocab.di.scope.ViewScope
import com.coder.vocab.network.OxfordApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [OxfordApiModule::class])
class ViewModule {

    @Provides
    @ViewScope
    fun provideOxfordApi(retrofit: Retrofit) = retrofit.create(OxfordApi::class.java)
}