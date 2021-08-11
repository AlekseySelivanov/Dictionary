package com.example.myapplication.view.main

import com.example.myapplication.model.data.AppState
import com.example.myapplication.model.data.DataModel
import com.example.myapplication.model.repository.Repository
import com.example.myapplication.model.repository.RepositoryLocal
import com.example.myapplication.viewmodel.Interactor

class MainInteractor(
    private val remoteRepository: Repository<DataModel>,
    private val localRepository: RepositoryLocal<DataModel>
) : Interactor<AppState> {
    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(remoteRepository.getData(word))
            localRepository.saveToDb(appState)
        } else {
            appState = AppState.Success(localRepository.getData(word))
        }
        return appState
    }
}