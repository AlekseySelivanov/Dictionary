package com.example.myapplication.viewmodel

interface InteractorHistorySearch<T> {
    suspend fun getDataByWord(word: String, fromRemoteSource: Boolean): T
}