package com.series.app.shared

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createNetworkModule(
    baseUrl: String,
    isDebug: Boolean
) = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(AuthorizationInterceptor())
            .addInterceptor(HttpLoggingInterceptor()
                .apply { setLevel(if (isDebug) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE) })
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

