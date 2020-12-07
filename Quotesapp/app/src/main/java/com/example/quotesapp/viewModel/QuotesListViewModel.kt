package com.example.quotesapp.viewModel

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.domain.GetQuoteListUseCase

class QuotesListViewModel(val getQuoteListUseCase: GetQuoteListUseCase): BaseViewModel() {
    fun fetchQuotesList(selectedTag: String): LiveData<List<Item>> {
        return getQuoteListUseCase.getQuoteList(selectedTag)
    }

    fun fetchSearchableQuotesList(searchWord: String): LiveData<List<Item>> {
        return getQuoteListUseCase.getSearchableQuoteList(searchWord)
    }

    fun favQuote(quote_id: Int): LiveData<List<Item>>{
        return getQuoteListUseCase.favQuote(quote_id)
    }

    fun myQuotes(): LiveData<List<Item>>{
        return getQuoteListUseCase.myQuotes()
    }
}