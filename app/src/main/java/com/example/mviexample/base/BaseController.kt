package com.example.mviexample.base

import android.os.Bundle
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.archlifecycle.LifecycleController


abstract class BaseController(args: Bundle? = null) : LifecycleController(args) {

    val topRouter: Router
        get() = topRouter()

    private fun topRouter(): Router {
        return when (val parent = parentController) {
            is BaseController -> {
                parent.topRouter()
            }
            is BaseController -> {
                parent.topRouter
            }
            else -> {
                router
            }
        }
    }
}