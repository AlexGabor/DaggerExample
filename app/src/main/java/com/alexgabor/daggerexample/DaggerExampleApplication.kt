package com.alexgabor.daggerexample

import android.app.Application
import com.alexgabor.daggerexample.di.AppComponent
import com.alexgabor.daggerexample.di.DaggerAppComponent

class DaggerExampleApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }
}


