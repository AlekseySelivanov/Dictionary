package com.example.myapplication.model.datasource

import com.example.myapplication.model.data.DataModel
import io.reactivex.Observable

class RoomDataBaseImpl:DataSource<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        TODO("Not yet implemented")
    }
}