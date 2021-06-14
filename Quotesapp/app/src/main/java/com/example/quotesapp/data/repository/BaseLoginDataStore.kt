package com.example.quotesapp.data.repository

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.api.SessionManager
import com.example.quotesapp.data.model.*
import com.example.quotesapp.view.Activities.LoginActivity
import kotlinx.coroutines.*
import retrofit2.HttpException
import retrofit2.Response
import timber.log.Timber

abstract class BaseLoginDataStore(@PublishedApi internal val service: ApiService, var context: Context) {
    abstract fun validateWithLogin(data: LoginData): LiveData<LoginResponse>


    inline fun authenticate(crossinline call: (ApiService) -> Deferred<Response<LoginResponse>>): LiveData<LoginResponse> {
        lateinit var pref: SharedPreferences
        pref = context.getSharedPreferences("Login", Context.MODE_PRIVATE)!!
        val editor = pref.edit()



        val result = MutableLiveData<LoginResponse>()

        CoroutineScope(Dispatchers.IO).launch {
            val request = call(service)
            withContext(Dispatchers.Main) {

                try {
                    val response = request.await()


                    if (response.isSuccessful) {

                        result.value = response.body()
                        editor.putString("sessionId", response.body()?.user_token)
                        editor.putString("email", response.body()?.email)

                        editor.putString("username", response.body()?.login)
                        editor.apply()
//                        sessionManager.saveAuthToken(response.body()!!.user_token.toString())

                    } else {
                        result.value?.message = response.body()?.message.toString()
                        Timber.d("Error occurred with code ${response.code()}")
                    }
                } catch (e: HttpException) {
                    result.value?.message = e.message
                    Timber.d("Error: ${e.message()}")
                } catch (e: Throwable) {
                    result.value?.message = e.message
                    Timber.d("Error: ${e.message}")
                }
            }
        }

        return result
    }
}