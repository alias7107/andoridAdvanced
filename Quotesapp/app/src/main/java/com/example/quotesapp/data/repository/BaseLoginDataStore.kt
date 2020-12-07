package com.example.quotesapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.data.model.LoginData
import com.example.quotesapp.data.model.LoginResponse
import com.example.quotesapp.data.model.QuoteResponse
import kotlinx.coroutines.*
import retrofit2.HttpException
import retrofit2.Response
import timber.log.Timber

abstract class BaseLoginDataStore(@PublishedApi internal val service: ApiService) {
    abstract fun validateWithLogin(data: LoginData): LiveData<LoginResponse>

    inline fun authenticate(crossinline call: (ApiService) -> Deferred<Response<LoginResponse>>): LiveData<LoginResponse> {
        val result = MutableLiveData<LoginResponse>()
        CoroutineScope(Dispatchers.IO).launch {
            val request = call(service)
            withContext(Dispatchers.Main) {
                try {
                    val response = request.await()
                    if (response.isSuccessful) {
                        result.value = response.body()
                    } else {
                        Timber.d("Error occurred with code ${response.code()}")
                    }
                } catch (e: HttpException) {
                    Timber.d("Error: ${e.message()}")
                } catch (e: Throwable) {
                    Timber.d("Error: ${e.message}")
                }
            }
        }

        return result
    }
}