package com.alexgabor.daggerexample.core

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
class LogRepo @Inject constructor() {

    private val _log = MutableStateFlow(listOf<String>())
    val log: Flow<List<String>> get() = _log

    init {
        log(this)
    }

    fun log(vararg args: Any) {
        _log.value = _log.value.toMutableList().apply {
            add(args.joinToString(prefix = "${getTime()} ", separator = " ") { arg ->
                if (arg is String) arg else "${arg.javaClass.simpleName}@${System.identityHashCode(arg)}"
            })
        }
    }

    private fun getTime(): String = DateTimeFormatter
        .ofPattern("mm:ss")
        .withLocale(Locale.getDefault())
        .withZone(ZoneId.systemDefault())
        .format(Instant.now())
}