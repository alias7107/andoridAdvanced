package com.example.quotesapp.viewModel

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.quotesapp.data.api.SessionManager
import com.example.quotesapp.data.api.SessionManager.Companion.USER_TOKEN
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.domain.GetQuoteListUseCase

class QuotesListViewModel(val getQuoteListUseCase: GetQuoteListUseCase): BaseViewModel() {
    private lateinit var sharedPreferences: SharedPreferences
    fun fetchQuotesList(selectedTag: String): LiveData<List<Item>> {
        return getQuoteListUseCase.getQuoteList(selectedTag)
    }

    fun fetchSearchableQuotesList(searchWord: String): LiveData<List<Item>> {
        return getQuoteListUseCase.getSearchableQuoteList(searchWord)
    }

    fun favQuote(quote_id: Int): LiveData<List<Item>>{
        return getQuoteListUseCase.favQuote(quote_id)
    }
    fun unfavQuote(quote_id: Int): LiveData<List<Item>>{
        return getQuoteListUseCase.unfavQuote(quote_id)
    }

    fun myQuotes(username: String): LiveData<List<Item>>{
        return getQuoteListUseCase.myQuotes(username)
    }
}