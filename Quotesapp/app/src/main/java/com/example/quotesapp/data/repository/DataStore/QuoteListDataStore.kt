package com.example.quotesapp.data.repository.DataStore
import androidx.lifecycle.LiveData

import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.data.repository.Base.BaseDataStore
import com.example.quotesapp.domain.Repository.QuoteListRepository

class QuoteListDataStore(apiService: ApiService): QuoteListRepository, BaseDataStore(apiService) {
    override fun loadData(selectedTag: String): LiveData<List<Item>> {
        return fetchData { service.getQuotesList(selectedTag, "tags") }
    }

    override fun searchedLoadData(searchWord: String): LiveData<List<Item>> {
        return fetchData { service.getSearchableQuotesList(searchWord) }
    }

    override fun myQuotes(username: String): LiveData<List<Item>> {
        return fetchData { service.getMyquotes(username,"user") }
    }



}