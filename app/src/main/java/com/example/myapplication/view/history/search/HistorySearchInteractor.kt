package com.example.myapplication.view.history.search

import com.example.myapplication.model.data.AppState
import com.example.myapplication.model.data.DataModel
import com.example.myapplication.model.repository.RepositoryLocal
import com.example.myapplication.viewmodel.InteractorHistorySearch

class HistorySearchInteractor(
    private val localRepository: RepositoryLocal<DataModel>
) : InteractorHistorySearch<AppState> {
    override suspend fun getDataByWord(word: String, fromRemoteSource: Boolean): AppState {
       val searchResult = localRepository.getDataByWord(word)
       return AppState.Success(listOf(searchResult))
    }
}