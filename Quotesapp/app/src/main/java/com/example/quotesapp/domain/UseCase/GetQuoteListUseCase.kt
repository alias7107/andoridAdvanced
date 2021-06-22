package com.example.quotesapp.domain.UseCase

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.domain.Repository.QuoteListRepository


class GetQuoteListUseCase(val quoteListRepository: QuoteListRepository) {
    fun getQuoteList(selectedTag: String): LiveData<List<Item>>{
        return quoteListRepository.loadData(selectedTag)
    }

    fun getSearchableQuoteList(searchWord: String): LiveData<List<Item>>{
        return quoteListRepository.searchedLoadData(searchWord)
    }


    fun myQuotes(username: String): LiveData<List<Item>>{
        return quoteListRepository.myQuotes(username)
    }
}