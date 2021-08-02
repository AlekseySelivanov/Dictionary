package com.example.myapplication.view.base

import com.example.myapplication.model.data.AppState

interface View {
    fun renderData(appState: AppState)
}