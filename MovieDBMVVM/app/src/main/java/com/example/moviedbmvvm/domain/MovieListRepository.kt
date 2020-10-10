package com.example.moviedbmvvm.domain

import androidx.lifecycle.LiveData
import com.example.moviedbmvvm.data.model.Item

interface MovieListRepository {
    fun loadData(): LiveData<List<Item>>
}