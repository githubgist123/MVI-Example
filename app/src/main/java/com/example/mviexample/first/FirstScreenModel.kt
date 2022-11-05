package com.example.mviexample.first

import androidx.compose.runtime.Immutable
import com.example.mviexample.base.UiEvent
import com.example.mviexample.base.UiState

@Immutable
sealed class FirstUiEvent : UiEvent {
    object ShowData : FirstUiEvent()
    data class ShowBottomSheet(val theme: List<String>) : FirstUiEvent()
}

@Immutable
data class FirstState(
    val isLoading: Boolean,
    val theme: List<String>
) : UiState {
    companion object {
        fun initial() = FirstState(
            isLoading = false,
            theme = emptyList()
        )
    }
}