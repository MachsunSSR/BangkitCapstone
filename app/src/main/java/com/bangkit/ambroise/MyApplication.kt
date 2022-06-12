package com.bangkit.ambroise

import android.app.Application
import com.bangkit.ambroise.core.di.networkModule
import com.bangkit.ambroise.core.di.repositoryModule
import com.bangkit.ambroise.di.useCaseModule
import com.bangkit.ambroise.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}