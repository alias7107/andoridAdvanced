package com.example.paginglibrary.data.api
import com.example.paginglibrary.data.model.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.paginglibrary.data.model.MovieResponse
import com.example.paginglibrary.utils.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path


interface ApiService {
    @GET("movie/top_rated")
     fun getPopularMoviesList(@Query("api_key") api_key:String, @Query("page") page: Int): Call<MovieResponse>
}