package com.example.myapplication.model.repository

import com.example.myapplication.model.data.DataModel
import com.example.myapplication.model.datasource.DataSource
import io.reactivex.Observable

class RepositoryImpl (private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}