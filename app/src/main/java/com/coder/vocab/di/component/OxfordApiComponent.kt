package com.coder.vocab.di.component

import com.coder.vocab.di.module.OxfordApiModule
import com.coder.vocab.network.OxfordApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [OxfordApiModule::class])
interface OxfordApiComponent {

    fun getOxfordApi(): OxfordApi
}