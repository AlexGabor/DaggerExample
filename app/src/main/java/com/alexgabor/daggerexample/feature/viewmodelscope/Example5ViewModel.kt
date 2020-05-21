package com.alexgabor.daggerexample.feature.viewmodelscope

import androidx.lifecycle.ViewModel
import com.alexgabor.daggerexample.core.FactoryRepo
import com.alexgabor.daggerexample.core.LogRepo
import com.alexgabor.daggerexample.core.SingleRepo
import com.alexgabor.daggerexample.core.ViewModelRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Example5ViewModel @Inject constructor(
    logRepo: LogRepo,
    factoryRepo: FactoryRepo,
    viewModelRepo: ViewModelRepo,
    singleRepo: SingleRepo,
    useCase: Example5UseCase
): ViewModel() {

    init {
        logRepo.log(this)
    }

    val logFlow: Flow<List<String>> = logRepo.log
}