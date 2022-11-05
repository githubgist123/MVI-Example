package com.example.mviexample.second

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bluelinelabs.conductor.Controller
import kotlinx.coroutines.launch

@Composable
fun SecondScreen(viewModel: SecondViewModel, controller: Controller) {
    val state by viewModel.state.collectAsState()

    Column {
        Log.d("myLogs", "OOPs")
        when {
            !state.isLoading -> {
                SecondContent(
                    viewModel = viewModel,
                    controller = controller,
                    theme = state.theme,
                    bottomSheetState = state.bottomSheetState
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SecondContent(viewModel: SecondViewModel, controller: Controller, theme: List<String>, bottomSheetState: SecondScreenBottomSheetState) {
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = {
            Log.d("myLogs", "confirmStateChange")
            viewModel.onShowBottomSheetClick()
            it != ModalBottomSheetValue.HalfExpanded
        },
        skipHalfExpanded = true
    )
    val coroutineScope = rememberCoroutineScope()

    BackHandler(sheetState.isVisible) {
        coroutineScope.launch { sheetState.hide() }
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            when (bottomSheetState) {
                SecondScreenBottomSheetState.ShowThemeBottomSheetState -> {
                    Box(modifier = Modifier
                        .height(400.dp)
                        .background(Color.Red)) {

                    }
                }
                SecondScreenBottomSheetState.ShowLanguageBottomSheetState -> {

                }
                SecondScreenBottomSheetState.ShowPinCodeBottomSheetState -> {

                }
                else -> {
                    Text(text = "Hello")
                }
            }
        }, modifier = Modifier.fillMaxSize()) {
        Box {
            Button(onClick = {
                viewModel.onShowBottomSheetClick()
            }) {
                Text(text = "Show bottom sheet")
            }

            if (!sheetState.isVisible && bottomSheetState != SecondScreenBottomSheetState.None) {
                LaunchedEffect(sheetState.currentValue) {
                    coroutineScope.launch {
                        sheetState.show()
                    }
                }
            }
        }
    }
}