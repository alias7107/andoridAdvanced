package com.example.moviedbmvvm.viewmodel

import androidx.lifecycle.LiveData
import com.example.moviedbmvvm.data.model.Item

import com.example.moviedbmvvm.domain.GetMovieListUseCase

class MovieListViewModel(val getMovieListUseCase: GetMovieListUseCase): BaseViewModel()  {
//    val movieListLive = MutableLiveData<List<Item>>()

    fun fetchMovieList():LiveData<List<Item>> {
        return getMovieListUseCase.getMovieList()
//        dataLoading.value = true
//        movieListRepository.getMovieList { isSuccess, response ->
//            dataLoading.value = false
//            if (isSuccess) {
//                movieListLive.value = response?.results
//                empty.value = false
//            } else {
//                empty.value = true
//            }
//        }
    }
}