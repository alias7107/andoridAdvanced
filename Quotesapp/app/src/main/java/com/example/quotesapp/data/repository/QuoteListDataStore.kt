package com.example.quotesapp.data.repository
import androidx.lifecycle.LiveData

import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.domain.QuoteListRepository
import com.example.quotesapp.utils.Constants

class QuoteListDataStore(apiService: ApiService): QuoteListRepository, BaseDataStore(apiService) {


    override fun loadData(selectedTag: String): LiveData<List<Item>> {
        return fetchData { service.getQuotesList(selectedTag, "tags") }
    }



}