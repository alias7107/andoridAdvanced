package com.example.quotesapp.domain

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.LoginData
import com.example.quotesapp.data.model.LoginResponse
import com.example.quotesapp.data.model.Quote

class PostQuoteUseCase (val postQuoteRepository: PostQuoteRepository) {
    fun PostQuote(quote: Quote): LiveData<Quote> {
        return postQuoteRepository.postQuote(quote)
    }
}