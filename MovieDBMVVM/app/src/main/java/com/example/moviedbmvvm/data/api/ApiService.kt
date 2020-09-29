package com.example.moviedbmvvm.data.api
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.moviedbmvvm.data.model.MovieResponse
import retrofit2.Response


interface ApiService {
    @GET("movie/top_rated")
    fun getPopularMoviesList(@Query("api_key") api_key:String): Call<MovieResponse>
}