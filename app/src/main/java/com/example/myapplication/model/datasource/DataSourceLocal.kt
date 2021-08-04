package com.example.myapplication.model.datasource


import com.example.myapplication.model.data.DataModel
import io.reactivex.Observable

class DataSourceLocal (private val localProvider:RoomDataBaseImpl):DataSource<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> = localProvider.getData(word)
}