package com.alexgabor.daggerexample.util

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.alexgabor.daggerexample.DaggerExampleApplication

val AppCompatActivity.injector
    get() = (application as DaggerExampleApplication).appComponent

val Fragment.injector
    get() = (requireActivity().application as DaggerExampleApplication).appComponent

val AppCompatActivity.viewModelComponent
    get() = injector.viewModelComponent().create()

val Fragment.viewModelComponent
    get() = injector.viewModelComponent().create()

@Suppress("UNCHECKED_CAST")
inline fun <reified VM : ViewModel> ComponentActivity.viewModels(
    crossinline provider: () -> VM
) = viewModels<VM> {
    object : ViewModelProvider.Factory {
        override fun <VM : ViewModel?> create(modelClass: Class<VM>): VM = provider() as VM
    }
}

@Suppress("UNCHECKED_CAST")
inline fun <reified VM : ViewModel> Fragment.viewModels(
    noinline ownerProducer: () -> ViewModelStoreOwner = { this },
    crossinline provider: () -> VM
) = viewModels<VM>(ownerProducer) {
    object : ViewModelProvider.Factory {
        override fun <VM : ViewModel?> create(modelClass: Class<VM>): VM {
            return provider() as VM
        }
    }
}

@Suppress("UNCHECKED_CAST")
inline fun <reified VM : ViewModel> Fragment.activityViewModels(
    crossinline provider: () -> VM
) = activityViewModels<VM> {
    object : ViewModelProvider.Factory {
        override fun <VM : ViewModel?> create(modelClass: Class<VM>): VM {
            return provider() as VM
        }
    }
}