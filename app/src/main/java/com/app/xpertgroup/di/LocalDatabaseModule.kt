package com.app.xpertgroup.di

import android.app.Application
import androidx.room.Room
import com.app.xpertgroup.domain.databaseManager.AppDatabase
import org.koin.dsl.module

val databaseModule = module {

    // Provide AppDatabase
    single {
        Room.databaseBuilder(
            get<Application>(),
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    single { get<AppDatabase>().AddressDao() }
    single { get<AppDatabase>().UserDao() }
    single { get<AppDatabase>().CompanyDao() }
    single { get<AppDatabase>().GeoDao() }
}