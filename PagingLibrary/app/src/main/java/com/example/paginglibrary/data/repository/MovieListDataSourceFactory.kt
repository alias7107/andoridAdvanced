package com.example.paginglibrary.data.repository


import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.paginglibrary.data.model.Item
import kotlin.coroutines.CoroutineContext


class MovieListDataSourceFactory : DataSource.Factory<Int, Item>() {

    val movieLiveDataSource = MutableLiveData<MovieListDataSource>()

    override fun create(): DataSource<Int, Item> {
        val movieListDataSource = MovieListDataSource()
        movieLiveDataSource.postValue(movieListDataSource)
        return movieListDataSource
    }

}