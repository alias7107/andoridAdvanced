package com.example.quotesapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.data.model.TypeHeadResponse
import kotlinx.coroutines.*
import retrofit2.HttpException
import retrofit2.Response
import timber.log.Timber

abstract class BaseTagDataStore(@PublishedApi internal val service: ApiService){

    abstract fun TagsData(): LiveData<List<Tags>>

    inline fun fetchTags(crossinline call: (ApiService) -> Deferred<Response<TypeHeadResponse>>): LiveData<List<Tags>> {
        val result = MutableLiveData<List<Tags>>()
        CoroutineScope(Dispatchers.IO).launch {
            val request = call(service)
            withContext(Dispatchers.Main) {
                try {
                    val response = request.await()
                    if (response.isSuccessful) {
                        result.value = response.body()?.tags
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