package com.bangkit.ambroise.core.di

import com.bangkit.ambroise.BuildConfig
import com.bangkit.ambroise.core.data.remote.RemoteDataSource
import com.bangkit.ambroise.core.data.remote.network.ApiService
import com.bangkit.ambroise.core.data.repository.UserRepository
import com.bangkit.ambroise.core.domain.repository.IUserRepository
import com.bangkit.ambroise.util.NetworkHelper.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        val loggingInterceptor =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(loggingInterceptor))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { RemoteDataSource(get()) }
    single<IUserRepository> { UserRepository(androidContext(), get()) }
}