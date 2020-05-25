package com.alexgabor.daggerexample.di

import com.alexgabor.daggerexample.feature.assistedInject.Example4ViewModel
import com.alexgabor.daggerexample.feature.assistedInject.Example4ViewModelWithArg
import com.alexgabor.daggerexample.feature.injectedSharedViewModel.Example3ActivityViewModel
import com.alexgabor.daggerexample.feature.injectedSharedViewModel.Example3ViewModel
import com.alexgabor.daggerexample.feature.injectedViewModelInActivity.Example1ViewModel
import com.alexgabor.daggerexample.feature.injectedViewModelInFragment.Example2ViewModel
import com.alexgabor.daggerexample.feature.viewmodelscope.Example5ViewModel
import dagger.Subcomponent

@ViewModelScope
@Subcomponent(modules = [AssistedModule::class])
interface ViewModelComponent {

    val example1ViewModel: Example1ViewModel

    val example2ViewModel: Example2ViewModel

    val example3ViewModel: Example3ViewModel

    val example3ActivityViewModel: Example3ActivityViewModel

    val example4ViewModel: Example4ViewModel

    val example4ViewModelFactory: Example4ViewModelWithArg.Factory

    val example5ViewModel: Example5ViewModel
}