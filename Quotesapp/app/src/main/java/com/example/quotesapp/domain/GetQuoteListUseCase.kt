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
}