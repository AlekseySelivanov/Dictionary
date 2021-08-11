package com.example.myapplication.model.repository

import com.example.myapplication.model.data.AppState

interface RepositoryLocal<T>:Repository<T> {
    suspend fun saveToDb(appState: AppState)
    suspend fun getDataByWord(word: String):T
}