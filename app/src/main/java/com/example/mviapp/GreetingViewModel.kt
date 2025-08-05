package com.example.mviapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GreetingViewModel: ViewModel() {

    private val _state = MutableStateFlow(GreetingState())
    val state: StateFlow<GreetingState> = _state.asStateFlow()

    fun processIntent(intent: GreetingIntent) {
        val currentState = _state.value
        when (intent) {
            is GreetingIntent.EnterName -> {
                _state.value = currentState.copy(name = intent.name)
            }
            GreetingIntent.Greet -> {
                _state.value = currentState.copy(
                    greeting = "Hello, ${currentState.name}"
                )
            }
        }
    }
}