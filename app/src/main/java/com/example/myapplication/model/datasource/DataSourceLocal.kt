package com.example.myapplication.model.datasource

import com.example.myapplication.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {
    suspend fun saveToDB(appState: AppState)
    suspend fun getDataByWord(word:String):T
}