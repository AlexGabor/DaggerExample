package com.alexgabor.daggerexample.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull

fun <T : Any> Flow<Event<T>>.consume() = mapNotNull { it.consume() }