package com.coder.vocab.di.component

import com.coder.vocab.di.FragmentScope
import com.coder.vocab.di.module.FragmentModule
import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {
}