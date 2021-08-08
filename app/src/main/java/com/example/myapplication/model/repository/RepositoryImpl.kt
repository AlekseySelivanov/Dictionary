package com.example.myapplication.model.repository

import com.example.myapplication.model.data.DataModel
import com.example.myapplication.model.datasource.DataSource

class RepositoryImpl (private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}