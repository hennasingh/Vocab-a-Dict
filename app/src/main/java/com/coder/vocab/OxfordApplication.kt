package com.coder.vocab

import android.app.Application
import com.coder.vocab.di.component.OxfordApiComponent

class OxfordApplication : Application() {

    lateinit var oxfordComponent: OxfordApiComponent

    override fun onCreate() {
        super.onCreate()

    }
}