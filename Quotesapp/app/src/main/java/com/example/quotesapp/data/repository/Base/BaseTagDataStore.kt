package com.example.quotesapp.data.repository.Base

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quotesapp.data.LocalDatabase.TagsDao
import com.example.quotesapp.data.LocalDatabase.TagsDatabase
import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.data.model.TypeHeadResponse
import kotlinx.coroutines.*
import retrofit2.HttpException
import retrofit2.Response
import timber.log.Timber

abstract class BaseTagDataStore(@PublishedApi internal val service: ApiService, var context: Context){

    abstract fun TagsData(): LiveData<List<Tags>>
    var dao: TagsDao = TagsDatabase.getDatabase(context).tagDao()

    inline fun fetchTags(crossinline call: (ApiService) -> Deferred<Response<TypeHeadResponse>>): LiveData<List<Tags>> {
        val result = MutableLiveData<List<Tags>>()
        CoroutineScope(Dispatchers.IO).launch {
            val request = call(service)
            withContext(Dispatchers.Main) {
                try {
                    val response = request.await()
                    if (response.isSuccessful) {
                        result.value = response.body()?.tags
                        result.value?.let { dao.insertAll(it) }
                    } else {
                        val data = withContext(Dispatchers.IO) {
                            dao.getAll()
                        }
                        if (data.isNotEmpty()) {
                            result.value = dao.getAll()
                        }
                        Timber.d("Error occurred with code ${response.code()}")
                    }
                } catch (e: HttpException) {
                    val data = withContext(Dispatchers.IO) {
                        dao.getAll()
                    }
                    if (data.isNotEmpty()) {
                        result.value = dao.getAll()
                    }
                    Timber.d("aa")
//                    Timber.d("Error: ${e.message()}")
                } catch (e: Throwable) {
                    val data = withContext(Dispatchers.IO) {
                        dao.getAll()
                    }
                    if (data.isNotEmpty()) {
                        result.value = dao.getAll()
                    }
                    Timber.d("aa")
//                    Timber.d("Error: ${e.message}")
                }
            }
        }

        return result
    }

}