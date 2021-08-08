package com.example.myapplication.model.repository


interface Repository<T> {
    suspend fun getData(word: String): T
}