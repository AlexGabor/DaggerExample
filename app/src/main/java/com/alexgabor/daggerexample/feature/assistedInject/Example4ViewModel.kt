package com.alexgabor.daggerexample.feature.assistedInject

import androidx.lifecycle.ViewModel
import com.alexgabor.daggerexample.util.Event
import com.alexgabor.daggerexample.util.consume
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class Example4ViewModel @Inject constructor() : ViewModel() {

    private val _messageEvent = MutableStateFlow<Event<String>?>(null)
    val messageEvent: Flow<String> = _messageEvent.filterNotNull().consume()

    fun sendMessage(message: String) {
        _messageEvent.value = Event(message)
    }
}