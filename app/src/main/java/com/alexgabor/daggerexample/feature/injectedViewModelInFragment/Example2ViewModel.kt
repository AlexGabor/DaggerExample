package com.alexgabor.daggerexample.feature.injectedViewModelInFragment

import androidx.lifecycle.ViewModel
import com.alexgabor.daggerexample.core.LogRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Example2ViewModel @Inject constructor(logRepo: LogRepo): ViewModel() {

    init {
        logRepo.log(this)
    }

    val logFlow: Flow<List<String>> = logRepo.log
}