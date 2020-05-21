package com.alexgabor.daggerexample.core

import javax.inject.Inject

class FactoryRepo @Inject constructor(logRepo: LogRepo) {

    init {
        logRepo.log(this)
    }
}