package com.example.moviedbmvvm.data.repository
import androidx.lifecycle.LiveData
import com.example.moviedbmvvm.data.api.ApiService
import com.example.moviedbmvvm.data.model.Item
import com.example.moviedbmvvm.domain.MovieListRepository
import com.example.moviedbmvvm.utils.Constants

class MovieListDataStore(apiService: ApiService):MovieListRepository, BaseDataStore(apiService) {


    override fun loadData(): LiveData<List<Item>> {
        return fetchData { service.getPopularMoviesList(Constants.MovieDBApiKey) }
    }


    // GET movie list
//    fun getMovieList(): Response<MovieResponse> {
//        return apiService.getPopularMoviesList(Constants.MovieDBApiKey)
//        apiService.getPopularMoviesList(Constants.MovieDBApiKey).enqueue(object : Callback<MovieResponse> {
//            override fun onResponse(call: Call<MovieResponse>?, response: Response<MovieResponse>?) {
//                if (response != null && response.isSuccessful) {
//                    onResult(true, response.body()!!)
//                } else
//                    onResult(false, null)
//            }
//
//            override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
//                onResult(false, null)
//            }
//
//        })
//    }


}