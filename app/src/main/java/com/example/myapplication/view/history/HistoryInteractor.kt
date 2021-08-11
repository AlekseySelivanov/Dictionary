package com.example.myapplication.view.history

import com.example.myapplication.model.data.AppState
import com.example.myapplication.model.data.DataModel
import com.example.myapplication.model.repository.RepositoryLocal
import com.example.myapplication.viewmodel.Interactor

class HistoryInteractor(
    private val localRepository: RepositoryLocal<DataModel>
) : Interactor<AppState> {
    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
            return AppState.Success(localRepository.getData(word))
    }
}