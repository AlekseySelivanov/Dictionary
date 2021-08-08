package com.example.myapplication.view.main

import com.example.myapplication.model.data.AppState
import com.example.myapplication.model.data.DataModel
import com.example.myapplication.model.repository.Repository
import com.example.myapplication.viewmodel.Interactor

class MainInteractor (
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {
    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(if (fromRemoteSource) {
            remoteRepository
        } else {
            localRepository
        }.getData(word)
        )
    }
}