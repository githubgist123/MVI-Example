package com.example.mviexample.first

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bluelinelabs.conductor.Controller
import com.example.mviexample.showAsBottomSheet

@Composable
fun FirstScreen(viewModel: FirstViewModel, controller: Controller) {
    val state by viewModel.state.collectAsState()

    Column {
        when {
            !state.isLoading -> {
                FirstContent(
                    viewModel = viewModel,
                    controller = controller,
                    theme = state.theme
                )
            }
        }
    }
}

@Composable
fun FirstContent(viewModel: FirstViewModel, controller: Controller, theme: List<String>) {
    Box {
        Button(onClick = {
            viewModel.onShowBottomSheetClick()
        }) {
            Text(text = "Show bottom sheet")
        }

        if (theme.isNotEmpty()) {
            controller.showAsBottomSheet {
                Box(modifier = Modifier
                    .height(400.dp)
                    .background(Color.Red)) {

                }
            }
        }
    }
}