package com.coder.vocab.ui.main

import android.os.Bundle
import com.coder.vocab.R
import com.coder.vocab.di.component.ActivityComponent
import com.coder.vocab.ui.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel>() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun setUpView(savedInstanceState: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }


}
