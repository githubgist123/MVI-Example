package com.example.mviexample.first

import com.example.mviexample.base.BaseViewModel
import com.example.mviexample.base.Reducer
import kotlinx.coroutines.flow.StateFlow

class FirstViewModel : BaseViewModel<FirstState, FirstUiEvent>() {

    private val reducer = FirstReducer(FirstState.initial())

    override val state: StateFlow<FirstState>
        get() = reducer.state

    fun onShowBottomSheetClick() {
        sendEvent(FirstUiEvent.ShowBottomSheet(theme = listOf("Hello", "World")))
    }

    private fun sendEvent(event: FirstUiEvent) {
        reducer.sendEvent(event)
    }

    private class FirstReducer(initial: FirstState) : Reducer<FirstState, FirstUiEvent>(initial) {
        override fun reduce(oldState: FirstState, event: FirstUiEvent) {
            when (event) {
                is FirstUiEvent.ShowData -> {
                    setState(oldState.copy(isLoading = false))
                }
                is FirstUiEvent.ShowBottomSheet -> {
                    setState(oldState.copy(theme = event.theme))
                }
            }
        }
    }
}