package com.example.quotesapp.data.api


import android.content.SharedPreferences
import com.example.quotesapp.data.model.LoginResponse
import com.example.quotesapp.utils.Constants.Companion.BASE_URL
import com.example.quotesapp.utils.Constants.Companion.DEBUG
import com.example.quotesapp.utils.Constants.Companion.REQUEST_TIMEOUT_DURATION
import com.google.gson.GsonBuilder
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

    fun getAuthInterceptor(sharedPreferences: SharedPreferences): Interceptor {
        return Interceptor { chain ->
            val newRequest = chain.request()
                .newBuilder()
                .addHeader("Authorization", "Token token=597b3b8ec128096c2fe0e32a65acb4e7")
                .addHeader("User-Token", "lnDZXtRBomCOj1tt8khiDcw4CKT7W6D1iRru1L+dXomprtZBDQ6VbzmNnMAGQz2wuu8j4wFpIseDhBofq4Q1pQ==")
                .build()

            chain.proceed(newRequest)
        }
    }
}