package com.app.xpertgroup.di

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

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
            .build()
    }

    factory { (service: Class<*>) -> get<Retrofit>().create(service) }
}