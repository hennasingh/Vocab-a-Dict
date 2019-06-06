package com.coder.vocab.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.coder.vocab.OxfordApplication
import com.coder.vocab.di.component.DaggerFragmentComponent
import com.coder.vocab.di.component.FragmentComponent
import com.coder.vocab.di.module.FragmentModule
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildFragmentComponent())
        super.onCreate(savedInstanceState)
        setUpObservers()
        viewModel.onCreate()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(provideLayoutId(), container, false)

    protected open fun setUpObservers() {
        viewModel.messageStringId.observe(this, Observer {
            showMessage(it)
        })

        viewModel.messageString.observe(this, Observer {
            showMessage(it)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
    }

    private fun buildFragmentComponent() =
        DaggerFragmentComponent
            .builder()
            .applicationComponent((context!!.applicationContext as OxfordApplication).applicationComponent)
            .fragmentModule(FragmentModule(this))
            .build()

    fun showMessage(message: String) = Toast.makeText(context, message, Toast.LENGTH_LONG).show()

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    //not explained in video
    fun goBack() {
        if (activity is BaseActivity<*>) (activity as BaseActivity<*>).goBack()
    }

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun setUpView(view: View)

    protected abstract fun injectDependencies(fragmentComponent: FragmentComponent)

}