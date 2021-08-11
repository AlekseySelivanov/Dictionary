package com.example.myapplication.model.datasource

import com.example.myapplication.model.data.AppState
import com.example.myapplication.model.data.DataModel
import com.example.myapplication.room.HistoryDao
import com.example.myapplication.utils.convertDataModelSuccessToEntity
import com.example.myapplication.utils.mapHistoryEntityToSearchResult
import com.example.myapplication.utils.mapHistoryEntityToSearchResultOneWord

class RoomDataBaseImpl(private val historyDao: HistoryDao) : DataSourceLocal<DataModel> {
    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }

    override suspend fun getDataByWord(word: String):DataModel {
        return mapHistoryEntityToSearchResultOneWord(historyDao.getDataByWord(word))
    }
}