package com.example.moviedbmvvm.domain

import androidx.lifecycle.LiveData
import com.example.moviedbmvvm.data.model.Item
import com.example.moviedbmvvm.data.repository.MovieListDataStore

class GetMovieListUseCase(val movieListRepository: MovieListRepository) {
    fun getMovieList(): LiveData<List<Item>>{
        return movieListRepository.loadData()
    }
}