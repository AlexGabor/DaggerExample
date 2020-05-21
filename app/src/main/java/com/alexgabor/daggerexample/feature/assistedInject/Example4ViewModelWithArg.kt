package com.alexgabor.daggerexample.feature.assistedInject

import androidx.lifecycle.ViewModel
import com.alexgabor.daggerexample.core.LogRepo
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.flow.Flow

class Example4ViewModelWithArg @AssistedInject constructor(
    @Assisted lateArg: String,
    logRepo: LogRepo
) : ViewModel() {

    init {
        logRepo.log(this, lateArg)
    }

    val logFlow: Flow<List<String>> = logRepo.log

    @AssistedInject.Factory
    interface Factory {
        fun create(lateArg: String): Example4ViewModelWithArg
    }
}