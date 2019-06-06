package com.coder.vocab.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.coder.vocab.OxfordApplication
import com.coder.vocab.di.component.ActivityComponent
import com.coder.vocab.di.component.DaggerActivityComponent
import com.coder.vocab.di.module.ActivityModule
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        setUpObservers()
        setUpView(savedInstanceState)
        viewModel.onCreate()
    }

    protected open fun setUpObservers() {
        viewModel.messageStringId.observe(this, Observer {
            showMessage(it)
        })

        viewModel.messageString.observe(this, Observer {
            showMessage(it)
        })
    }

    private fun buildActivityComponent() =
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as OxfordApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()

    fun showMessage(message: String) = Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    open fun goBack() = onBackPressed()

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun setUpView(savedInstanceState: Bundle?)

    protected abstract fun injectDependencies(activityComponent: ActivityComponent)
}