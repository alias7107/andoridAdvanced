package com.example.quotesapp.data.repository.DataStore

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.data.repository.Base.BaseQuoteDataStore
import com.example.quotesapp.domain.Repository.GetQuoteRepository

class QuoteDataStore (apiService: ApiService): GetQuoteRepository, BaseQuoteDataStore(apiService) {
    override fun getQuoteById(quote_id: Int): LiveData<Item> {
        return fetchData { service.GetQuote(quote_id) }
    }

    override fun favQuote(quote_id: Int): LiveData<Item> {
        return fetchData { service.favQuote(quote_id) }
    }

    override fun unfavQuote(quote_id: Int): LiveData<Item> {
        return fetchData { service.unfavQuote(quote_id) }
    }
}