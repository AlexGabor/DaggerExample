package com.alexgabor.daggerexample.core

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SingleRepo @Inject constructor(logRepo: LogRepo) {

    init {
        logRepo.log(this)
    }
}