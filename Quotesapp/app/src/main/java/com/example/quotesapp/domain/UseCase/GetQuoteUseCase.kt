package com.example.quotesapp.domain.UseCase

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.domain.Repository.GetQuoteRepository
import com.example.quotesapp.domain.Repository.QuoteListRepository

class GetQuoteUseCase (val getQuoteRepository: GetQuoteRepository) {
    fun getQuote(quote_id: Int): LiveData<Item> {
        return getQuoteRepository.getQuoteById(quote_id)
    }

    fun favQuote(quote_id: Int): LiveData<Item>{
        return getQuoteRepository.favQuote(quote_id)
    }

    fun unfavQuote(quote_id: Int): LiveData<Item>{
        return getQuoteRepository.unfavQuote(quote_id)
    }
}