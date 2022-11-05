package com.example.mviexample.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import com.example.bottomsheetexample.ui.theme.AppTheme
import com.example.mviexample.base.BaseController
import com.example.mviexample.viewModel

class FirstController : BaseController() {

    private val viewModel: FirstViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedViewState: Bundle?
    ): View {
        return ComposeView(container.context).apply {
            setContent {
                AppTheme {
                    FirstScreen(viewModel = viewModel, controller = this@FirstController)
                }
            }
        }
    }
}