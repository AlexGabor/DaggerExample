package com.alexgabor.daggerexample.feature.injectedSharedViewModel

import androidx.lifecycle.ViewModel
import com.alexgabor.daggerexample.core.LogRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Example3ActivityViewModel @Inject constructor(logRepo: LogRepo): ViewModel() {

    init {
        logRepo.log(this)
    }

    val logFlow: Flow<List<String>> = logRepo.log
}