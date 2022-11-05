package com.example.mviexample

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bluelinelabs.conductor.archlifecycle.LifecycleController

inline fun <reified VM : ViewModel, T> T.viewModel(): Lazy<VM> where T : LifecycleController {
    return lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProvider(this.activity as AppCompatActivity)[VM::class.java]
    }
}