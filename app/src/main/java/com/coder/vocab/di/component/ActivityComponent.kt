package com.coder.vocab.di.component

import com.coder.vocab.di.ActivityScope
import com.coder.vocab.di.module.ActivityModule
import com.coder.vocab.ui.main.MainActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: MainActivity)
}