package com.example.paginglibrary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.paginglibrary.data.api.State
import com.example.paginglibrary.data.model.Item
import com.example.paginglibrary.data.repository.MovieListDataSource
import com.example.paginglibrary.data.repository.MovieListDataSourceFactory
import kotlinx.coroutines.Dispatchers


class MovieListViewModel: ViewModel()  {
//    val movieListLive = MutableLiveData<List<Item>>()
    var moviePageList: LiveData<PagedList<Item>>
    private var liveDataSource: LiveData<MovieListDataSource>

    init {
        val itemDataSourceFactory = MovieListDataSourceFactory()

        liveDataSource = itemDataSourceFactory.movieLiveDataSource


        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(MovieListDataSource.PAGE_SIZE)
            .build()



        moviePageList = LivePagedListBuilder(itemDataSourceFactory, config)
            .build()

    }
}