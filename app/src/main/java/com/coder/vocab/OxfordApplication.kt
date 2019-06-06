package com.coder.vocab

import android.app.Application
import com.coder.vocab.di.component.ApplicationComponent
import com.coder.vocab.di.component.DaggerApplicationComponent
import com.coder.vocab.di.module.ApplicationModule

class OxfordApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()

    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()

        applicationComponent.inject(this)
    }
}