package com.example.quotesapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.data.model.QuoteResponse
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.data.model.TypeHeadResponse

import retrofit2.HttpException
import retrofit2.Response
import kotlinx.coroutines.*
import timber.log.Timber

abstract class BaseDataStore(@PublishedApi internal val service: ApiService) {

    abstract fun loadData(selectedTag: String): LiveData<List<Item>>

    abstract fun searchedLoadData(searchWord: String): LiveData<List<Item>>

    inline fun fetchData(crossinline call: (ApiService) -> Deferred<Response<QuoteResponse>>): LiveData<List<Item>> {
        val result = MutableLiveData<List<Item>>()
        CoroutineScope(Dispatchers.IO).launch {
            val request = call(service)
            withContext(Dispatchers.Main) {
                try {
                    val response = request.await()
                    if (response.isSuccessful) {
                        result.value = response.body()?.quotes
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