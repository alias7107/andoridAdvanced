package com.example.quotesapp.data.repository.Base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.data.model.QuoteResponse
import com.example.quotesapp.data.model.UserProfile
import kotlinx.coroutines.*
import retrofit2.HttpException
import retrofit2.Response
import timber.log.Timber

abstract class BaseProfileDataStore(@PublishedApi internal val service: ApiService) {
    abstract fun loadUser(): LiveData<UserProfile>

    inline fun fetchUser(crossinline call: (ApiService) -> Deferred<Response<UserProfile>>): LiveData<UserProfile> {
        val result = MutableLiveData<UserProfile>()
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