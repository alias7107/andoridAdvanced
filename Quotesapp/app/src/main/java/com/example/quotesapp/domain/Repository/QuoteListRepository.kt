package com.example.quotesapp.domain.Repository

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Item

interface QuoteListRepository {
    fun loadData(selectedTag: String): LiveData<List<Item>>
    fun searchedLoadData(searchWord: String): LiveData<List<Item>>
    fun myQuotes(username: String): LiveData<List<Item>>
}