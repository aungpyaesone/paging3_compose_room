package com.aps.passing_data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ShareViewModel : ViewModel() {

    private val _shareState = MutableStateFlow(0)
    val shareState = _shareState.asStateFlow()

    fun updateState(){
        _shareState.value++
    }

    override fun onCleared() {
        super.onCleared()
        println("viewModel cleared")
    }
}