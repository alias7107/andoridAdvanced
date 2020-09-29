package com.example.moviedbmvvm.data.repository
import android.util.Log
import com.example.moviedbmvvm.data.api.ApiClient
import com.example.moviedbmvvm.data.model.Item
import com.example.moviedbmvvm.data.model.MovieResponse
import com.example.moviedbmvvm.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListRepository {

    // GET movie list
    fun getMovieList(onResult: (isSuccess: Boolean, response: MovieResponse?) -> Unit) {

        ApiClient.instance.getPopularMoviesList(Constants.MovieDBApiKey).enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>?, response: Response<MovieResponse>?) {

                if (response != null && response.isSuccessful) {
                    onResult(true, response.body()!!)

                } else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
                Log.d("response", t.toString())

                onResult(false, null)
            }

        })
    }

    companion object {
        private var INSTANCE: MovieListRepository? = null
        fun getInstance() = INSTANCE
            ?: MovieListRepository().also {
                INSTANCE = it
            }
    }
}