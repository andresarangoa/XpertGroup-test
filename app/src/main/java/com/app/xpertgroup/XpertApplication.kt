package com.app.xpertgroup

import android.app.Application
import android.os.Build
import com.app.xpertgroup.di.networkModule
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

    private fun isRunningTest(): Boolean {
        return "robolectric" == Build.FINGERPRINT
    }

    private fun getKoinModules() = listOf(
        networkModule,
        viewModelModule,
    )

}