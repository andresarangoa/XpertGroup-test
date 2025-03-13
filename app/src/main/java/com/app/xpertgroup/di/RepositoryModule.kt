package com.app.xpertgroup.di

import com.app.xpertgroup.data.UsersLocalDataSourceImp
import com.app.xpertgroup.data.UsersRemoteDataSourceImp
import com.app.xpertgroup.data.UsersRepositoryImp
import com.app.xpertgroup.domain.datasource.UsersLocalDataSource
import com.app.xpertgroup.domain.datasource.UsersRemoteDatasource
import com.app.xpertgroup.domain.repository.Api
import com.app.xpertgroup.domain.repository.UsersRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val repositoryModule = module {

    single { UsersRemoteDataSourceImp(usersApi = get<Retrofit>().create(Api::class.java)) }
    single { UsersLocalDataSourceImp(userDao = get(), geoDao = get(), addressDao = get(), companyDao = get()) }

    single<UsersRemoteDatasource> { get<UsersRemoteDataSourceImp>() }
    single<UsersLocalDataSource> { get<UsersLocalDataSourceImp>() }

    single<UsersRepository> {
        UsersRepositoryImp(usersRemoteDataSourceImp = get(), usersLocalDataSourceImp = get(), networkHandler = get())
    }
}
