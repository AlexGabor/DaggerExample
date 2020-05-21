package com.alexgabor.daggerexample.core

import com.alexgabor.daggerexample.di.ViewModelScope
import javax.inject.Inject

@ViewModelScope
class ViewModelRepo @Inject constructor(logRepo: LogRepo) {

    init {
        logRepo.log(this)
    }
}