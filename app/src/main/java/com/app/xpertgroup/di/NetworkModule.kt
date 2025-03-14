package com.app.xpertgroup.di

import com.app.xpertgroup.data.platform.NetworkHandler
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

val networkModule = module {

    single {
        OkHttpClient.Builder()
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory { (service: Class<*>) -> get<Retrofit>().create(service) }

    single { NetworkHandler(androidContext()) }
}