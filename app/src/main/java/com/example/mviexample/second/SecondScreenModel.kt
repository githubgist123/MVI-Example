package com.example.mviexample.second

import androidx.compose.runtime.Immutable
import com.example.mviexample.base.UiEvent
import com.example.mviexample.base.UiState

@Immutable
sealed class SecondUiEvent : UiEvent {
    data class ShowData(val theme: List<String>, val bottomSheetState: SecondScreenBottomSheetState) : SecondUiEvent()
    data class ShowBottomSheet(val theme: List<String>, val bottomSheetState: SecondScreenBottomSheetState) : SecondUiEvent()
}

@Immutable
data class SecondState(
    val isLoading: Boolean,
    val bottomSheetState: SecondScreenBottomSheetState,
    val theme: List<String>
) : UiState {
    companion object {
        fun initial() = SecondState(
            isLoading = false,
            theme = emptyList(),
            bottomSheetState = SecondScreenBottomSheetState.None
        )
    }
}

sealed class SecondScreenBottomSheetState {
    object None : SecondScreenBottomSheetState()
    object ShowThemeBottomSheetState : SecondScreenBottomSheetState()
    object ShowLanguageBottomSheetState : SecondScreenBottomSheetState()
    object ShowPinCodeBottomSheetState: SecondScreenBottomSheetState()
}