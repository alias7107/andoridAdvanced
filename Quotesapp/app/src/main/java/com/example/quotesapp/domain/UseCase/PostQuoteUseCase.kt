package com.example.quotesapp.domain.UseCase

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Quote
import com.example.quotesapp.domain.Repository.PostQuoteRepository

class PostQuoteUseCase (val postQuoteRepository: PostQuoteRepository) {
    fun PostQuote(quote: Quote): LiveData<Quote> {
        return postQuoteRepository.postQuote(quote)
    }
}