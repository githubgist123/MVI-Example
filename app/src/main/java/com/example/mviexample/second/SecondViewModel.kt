package com.example.mviexample.second

import com.example.mviexample.base.BaseViewModel
import com.example.mviexample.base.Reducer
import kotlinx.coroutines.flow.StateFlow

class SecondViewModel : BaseViewModel<SecondState, SecondUiEvent>() {
    private val reducer = FirstReducer(SecondState.initial())

    override val state: StateFlow<SecondState>
        get() = reducer.state

    fun onShowBottomSheetClick() {
        sendEvent(
            SecondUiEvent.ShowBottomSheet(
                theme = listOf("Hello", "World"),
                SecondScreenBottomSheetState.ShowThemeBottomSheetState
            )
        )
    }

    private fun sendEvent(event: SecondUiEvent) {
        reducer.sendEvent(event)
    }

    private class FirstReducer(initial: SecondState) :
        Reducer<SecondState, SecondUiEvent>(initial) {
        override fun reduce(oldState: SecondState, event: SecondUiEvent) {
            when (event) {
                is SecondUiEvent.ShowData -> {
                    setState(oldState.copy(isLoading = false))
                }
                is SecondUiEvent.ShowBottomSheet -> {
                    setState(
                        oldState.copy(
                            theme = event.theme,
                            bottomSheetState = event.bottomSheetState
                        )
                    )
                }
            }
        }
    }
}