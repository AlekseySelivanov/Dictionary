package com.example.myapplication.model.datasource

import com.example.myapplication.model.data.DataModel

class RoomDataBaseImpl :DataSource<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> {
        TODO("Not yet implemented")
    }
}