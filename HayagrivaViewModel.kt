package com.s2b.hayagriva

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HayagrivaViewModel : ViewModel() {
    private val _status = MutableStateFlow("Ready")
    val status: StateFlow<String> = _status

    fun setStatus(value: String) {
        _status.value = value
    }
}
