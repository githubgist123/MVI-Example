package com.example.mviexample.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.asTransaction
import com.example.bottomsheetexample.ui.theme.AppTheme
import com.example.mviexample.first.FirstController
import com.example.mviexample.second.SecondController

class MainController : Controller() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedViewState: Bundle?
    ): View {
        return ComposeView(container.context).apply {
            setContent {
                AppTheme {
                    Column {
                        Button(onClick = {
                            router.pushController(
                                FirstController().asTransaction()
                            )
                        }) {
                            Text(text = "Open first controller")
                        }
                        Button(onClick = {
                            router.pushController(
                                SecondController().asTransaction()
                            )
                        }) {
                            Text(text = "Open second controller")
                        }
                    }
                }
            }
        }
    }
}