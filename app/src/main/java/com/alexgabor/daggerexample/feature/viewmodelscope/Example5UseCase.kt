package com.alexgabor.daggerexample.feature.viewmodelscope

import com.alexgabor.daggerexample.core.FactoryRepo
import com.alexgabor.daggerexample.core.LogRepo
import com.alexgabor.daggerexample.core.SingleRepo
import com.alexgabor.daggerexample.core.ViewModelRepo
import javax.inject.Inject

class Example5UseCase @Inject constructor(
    logRepo: LogRepo,
    factoryRepo: FactoryRepo,
    viewModelRepo: ViewModelRepo,
    singleRepo: SingleRepo
) {
    init {
        logRepo.log(this)
    }
}