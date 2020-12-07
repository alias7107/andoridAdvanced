package com.example.quotesapp.data.repository

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.model.LoginData
import com.example.quotesapp.data.model.LoginResponse
import com.example.quotesapp.data.model.Quote
import com.example.quotesapp.domain.AccountRepository
import com.example.quotesapp.domain.PostQuoteRepository

class PostQuoteDataStore (apiService: ApiService): PostQuoteRepository, BasePostQuote(apiService) {


    override fun postQuote(data: Quote): LiveData<Quote> {
        return postData { service.postUserQuote(data) }
    }
}



