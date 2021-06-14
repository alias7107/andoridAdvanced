package com.example.quotesapp.data.api


import android.content.SharedPreferences
import com.example.quotesapp.data.api.SessionManager.Companion.USER_TOKEN
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
//        val sessionManager = SessionManager(Context)
        return Interceptor { chain ->
            val newRequest = chain.request()
                .newBuilder().also{
                    it.addHeader("Authorization", "Token token=597b3b8ec128096c2fe0e32a65acb4e7")
                    val sessionID = sharedPreferences.getString("sessionId", null)?.let{sharedPreferences.getString("sessionId", null)}!!
                    it.addHeader( "User-Token", sessionID)
//                   {newRequest.header("User-Token", sharedPreferences.getString("sessionId", null))}
                }
//                .addHeader("User-Token", "AuKW/fCl+0yqXlfj/aT8mSKvo0eVNQnP+d6F89mn1AN8nYFDnzwHiaSDULeZSyTiqAc3oF87J7q+HJlzhk3eYA==")
//                .addHeader("User-Token", sharedPreferences.getString("sessionId", null))


//            sessionManager.fetchAuthToken()?.let{
//                newRequest.addHeader("User-Token", it)
//            }
//            sharedPreferences.getString("sessionId", null)?.let{newRequest.header("User-Token", sharedPreferences.getString("sessionId", null))}
//            sharedPreferences.getString(USER_TOKEN,null)?.let{newRequest.header("User-Token: ${sharedPreferences.getString(USER_TOKEN, null)}")}

            chain.proceed(newRequest.build())
        }
    }
}