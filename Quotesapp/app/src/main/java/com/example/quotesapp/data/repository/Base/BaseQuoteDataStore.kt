package com.example.quotesapp.data.repository.Base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.data.model.QuoteResponse
import kotlinx.coroutines.*
import retrofit2.HttpException
import retrofit2.Response
import timber.log.Timber

abstract class BaseQuoteDataStore(@PublishedApi internal val service: ApiService) {
    abstract fun getQuoteById(quote_id:Int): LiveData<Item>
    abstract fun favQuote(quote_id: Int): LiveData<Item>
    abstract fun unfavQuote(quote_id: Int): LiveData<Item>

    inline fun fetchData(crossinline call: (ApiService) -> Deferred<Response<Item>>): LiveData<Item> {
        val result = MutableLiveData<Item>()
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