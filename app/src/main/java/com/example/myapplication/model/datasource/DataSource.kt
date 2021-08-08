package com.example.myapplication.model.datasource


interface DataSource<T> {
    suspend fun getData(word: String): T
}