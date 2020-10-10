package com.example.moviedbmvvm.data.api
import com.example.moviedbmvvm.data.model.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.moviedbmvvm.data.model.MovieResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Path


interface ApiService {
    @GET("movie/top_rated")
     fun getPopularMoviesList(@Query("api_key") api_key:String): Deferred<Response<MovieResponse>>

}