package com.example.quotesapp.data.api

import com.example.quotesapp.utils.Constants.Companion.BASE_URL
import com.example.quotesapp.utils.Constants.Companion.QUOTES_API_KEY
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ApiClient {

    fun create(okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }

    fun getOkHttpClient(authInterceptor: Interceptor): OkHttpClient {
        val logginInterceptor = HttpLoggingInterceptor()
        logginInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        return builder.addInterceptor(logginInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .followRedirects(true)
            .followSslRedirects(true)
            .addInterceptor(authInterceptor)
            .build()
    }

    fun getAuthInterceptor(sessionManager: SessionManager): Interceptor {
        return Interceptor { chain ->
            val newRequest = chain.request()
                .newBuilder().also{
                    it.addHeader("Authorization", QUOTES_API_KEY)
                }

            sessionManager.fetchSessionId()?.let{result-> newRequest.header("User-Token", result)}
            chain.proceed(newRequest.build())
        }
    }
}