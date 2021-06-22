package com.example.quotesapp.data.repository.DataStore

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.model.Quote
import com.example.quotesapp.data.repository.Base.BasePostQuote
import com.example.quotesapp.domain.Repository.PostQuoteRepository

class PostQuoteDataStore (apiService: ApiService): PostQuoteRepository, BasePostQuote(apiService) {


    override fun postQuote(data: Quote): LiveData<Quote> {
        return postData { service.postUserQuote(data) }
    }
}



