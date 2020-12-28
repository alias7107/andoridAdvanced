package com.example.quotesapp.domain

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Item


class GetQuoteListUseCase(val quoteListRepository: QuoteListRepository) {
    fun getQuoteList(selectedTag: String): LiveData<List<Item>>{
        return quoteListRepository.loadData(selectedTag)
    }

    fun getSearchableQuoteList(searchWord: String): LiveData<List<Item>>{
        return quoteListRepository.searchedLoadData(searchWord)
    }

    fun favQuote(quote_id: Int): LiveData<List<Item>>{
        return quoteListRepository.favQuote(quote_id)
    }
    fun unfavQuote(quote_id: Int): LiveData<List<Item>>{
        return quoteListRepository.unfavQuote(quote_id)
    }
    fun myQuotes(username: String): LiveData<List<Item>>{
        return quoteListRepository.myQuotes(username)
    }
}