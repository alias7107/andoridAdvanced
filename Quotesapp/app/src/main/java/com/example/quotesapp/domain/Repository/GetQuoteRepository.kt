package com.example.quotesapp.domain.Repository

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Item

interface GetQuoteRepository {
    fun getQuoteById(quote_id: Int): LiveData<Item>
    fun favQuote(quote_id: Int): LiveData<Item>
    fun unfavQuote(quote_id: Int): LiveData<Item>
}