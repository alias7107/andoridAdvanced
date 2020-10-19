package com.example.quotesapp.domain

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Item


class GetQuoteListUseCase(val quoteListRepository: QuoteListRepository) {
    fun getQuoteList(): LiveData<List<Item>>{
        return quoteListRepository.loadData()
    }
}