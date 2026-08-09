package com.s2b.hayagriva.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HayagrivaViewModel : ViewModel() {
    var input: String = ""
        private set
    var state: String = "READY"
    var listening: Boolean = false
        private set

    val greeting: String
        get() = "Hello. I’m Hayagriva. How can I help?"

    fun setInput(value: String) { input = value }

    fun send() {
        if (input.isBlank()) return
        state = "THINKING"
        viewModelScope.launch {
            delay(500)
            state = "READY"
        }
    }

    fun quick(command: String) {
        input = command
        send()
    }

    fun toggleListening() {
        listening = !listening
        state = if (listening) "LISTENING" else "READY"
    }
}
