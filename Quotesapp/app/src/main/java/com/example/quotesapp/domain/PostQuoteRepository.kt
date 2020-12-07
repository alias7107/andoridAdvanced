package com.example.quotesapp.domain

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Quote
import com.example.quotesapp.data.model.UserProfile

interface PostQuoteRepository {
    fun postQuote(quote: Quote): LiveData<Quote>
}