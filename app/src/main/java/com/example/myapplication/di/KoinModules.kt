package com.example.myapplication.di

import com.example.myapplication.model.data.DataModel
import com.example.myapplication.model.datasource.RetrofitImpl
import com.example.myapplication.model.datasource.RoomDataBaseImpl
import com.example.myapplication.model.repository.Repository
import com.example.myapplication.model.repository.RepositoryImpl
import com.example.myapplication.view.main.MainInteractor
import com.example.myapplication.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) { RepositoryImpl(RetrofitImpl()) }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) { RepositoryImpl(RoomDataBaseImpl()) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}