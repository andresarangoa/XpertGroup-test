package com.app.xpertgroup

import android.app.Application
import com.app.xpertgroup.di.databaseModule
import com.app.xpertgroup.di.networkModule
import com.app.xpertgroup.di.repositoryModule
import com.app.xpertgroup.di.useCasesModule
import com.app.xpertgroup.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class XpertApplication: Application()  {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@XpertApplication)
            loadKoinModules(getKoinModules())
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }

    private fun getKoinModules() = listOf(
        networkModule,
        repositoryModule,
        useCasesModule,
        viewModelModule,
        databaseModule
    )

}