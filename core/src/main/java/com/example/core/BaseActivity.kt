package com.example.core

import androidx.appcompat.app.AppCompatActivity
import com.example.core.viewmodel.BaseViewModel

import com.example.translator.model.data.AppState


abstract class BaseActivity<T : AppState> : AppCompatActivity() {
    abstract val model: BaseViewModel<T>
    protected fun renderData(appState: T) {
        when (appState) {
            is AppState.Success -> {
                val dataModel = appState.data
                if (dataModel == null || dataModel.isEmpty()) {
                    showErrorScreen(getString(R.string.error_empty_response))
                } else {
                    showViewSuccess()
                    onLoadingSuccess(appState)
                }
            }
            is AppState.Loading -> {
                showViewLoading()
            }
            is AppState.Error -> {
                showErrorScreen(appState.error.message)
            }
        }

    }

    abstract fun showErrorScreen(error: String?)

    abstract fun showViewSuccess()

    abstract fun showViewLoading()

    abstract fun showViewError()

    abstract fun onLoadingSuccess(appState: AppState.Success)
}