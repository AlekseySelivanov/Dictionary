package com.example.myapplication.model.datasource

import com.example.myapplication.model.data.DataModel

class DataSourceRemote (private val remoteProvider:RetrofitImpl):DataSource<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> = remoteProvider.getData(word)
}