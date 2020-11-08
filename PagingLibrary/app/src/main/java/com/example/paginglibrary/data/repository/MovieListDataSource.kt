package com.example.paginglibrary.data.repository
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.paginglibrary.data.api.ApiClient
import com.example.paginglibrary.data.api.ApiService
import com.example.paginglibrary.data.api.State
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.paginglibrary.data.model.Item
import com.example.paginglibrary.data.model.MovieResponse
import com.example.paginglibrary.utils.Constants
import com.example.paginglibrary.utils.Constants.Companion.MovieDBApiKey
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext



class MovieListDataSource : PageKeyedDataSource<Int, Item>() {



    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        val service = ApiClient.buildService(ApiService::class.java)
        val call = service.getPopularMoviesList(MovieDBApiKey,params.key)

        call.enqueue(object : Callback<MovieResponse> {

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.results
                    val key = if (params.key > 1) params.key - 1 else 0
                    responseItems?.let {
                        callback.onResult(responseItems, key)
                    }
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }

        })

    }



    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Item>) {
        val service = ApiClient.buildService(ApiService::class.java)
        val call = service.getPopularMoviesList(MovieDBApiKey, FIRST_PAGE)
        call.enqueue(object : Callback<MovieResponse> {



            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {

                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.results
                    responseItems?.let {
                        callback.onResult(responseItems, null, FIRST_PAGE + 1)
                    }
                }

            }


            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
        })
    }



    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {

        val service = ApiClient.buildService(ApiService::class.java)

        val call = service.getPopularMoviesList(MovieDBApiKey,params.key)

        call.enqueue(object : Callback<MovieResponse> {



            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {

                if (response.isSuccessful) {

                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.results
                    val key = params.key + 1

                    responseItems?.let {
                        callback.onResult(responseItems, key)

                    }

                }

            }



            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
        })



    }



    companion object {
        const val PAGE_SIZE = 6
        const val FIRST_PAGE = 1
    }



}