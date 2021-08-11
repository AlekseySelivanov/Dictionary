package com.example.myapplication.di

import androidx.room.Room
import com.example.myapplication.model.data.DataModel
import com.example.myapplication.model.datasource.RetrofitImpl
import com.example.myapplication.model.datasource.RoomDataBaseImpl
import com.example.myapplication.model.repository.Repository
import com.example.myapplication.model.repository.RepositoryImpl
import com.example.myapplication.model.repository.RepositoryLocal
import com.example.myapplication.model.repository.RepositoryLocalImpl
import com.example.myapplication.room.HistoryDatabase
import com.example.myapplication.view.history.HistoryInteractor
import com.example.myapplication.view.history.HistoryViewModel
import com.example.myapplication.view.history.search.HistorySearchInteractor
import com.example.myapplication.view.history.search.HistorySearchViewModel
import com.example.myapplication.view.main.MainInteractor
import com.example.myapplication.view.main.MainViewModel
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDatabase::class.java, "HistoryDB").build() }
    single { get<HistoryDatabase>().historyDao() }
    single<Repository<DataModel>> { RepositoryImpl(RetrofitImpl()) }
    single<RepositoryLocal<DataModel>> { RepositoryLocalImpl(RoomDataBaseImpl(get())) }
}

val mainScreen = module {
    factory { MainInteractor(get(), get()) }
    factory { MainViewModel(get()) }
}

val historyScreen = module {
    factory { HistoryInteractor(get()) }
    factory { HistoryViewModel(get()) }
}
val historySearchScreen = module {
    factory { HistorySearchInteractor(get()) }
    factory { HistorySearchViewModel(get()) }
}