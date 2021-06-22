package com.example.quotesapp.viewModel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.domain.UseCase.GetQuoteListUseCase
import com.example.quotesapp.domain.UseCase.GetQuoteUseCase

class QuotesListViewModel(val getQuoteListUseCase: GetQuoteListUseCase, val getQuoteUseCase: GetQuoteUseCase): BaseViewModel() {
    private lateinit var sharedPreferences: SharedPreferences
    private var quotesList = MutableLiveData<List<Item>>()
//    private var tagsList = MutableLiveData<List<Tags>>()
//    private var tagsList = MutableLiveData<List<Tags>>()

    fun fetchQuotesList(selectedTag: String) {
        quotesList =  getQuoteListUseCase.getQuoteList(selectedTag) as MutableLiveData<List<Item>>
    }

    fun getQuotesList(): LiveData<List<Item>> {
        return quotesList
    }

    fun fetchSearchableQuotesList(searchWord: String): LiveData<List<Item>> {
        return getQuoteListUseCase.getSearchableQuoteList(searchWord)
    }

    fun favQuote(quote_id: Int): LiveData<Item>{
        return getQuoteUseCase.favQuote(quote_id)
    }
    fun unfavQuote(quote_id: Int): LiveData<Item>{
        return getQuoteUseCase.unfavQuote(quote_id)
    }



    fun myQuotes(username: String): LiveData<List<Item>>{
        return getQuoteListUseCase.myQuotes(username)
    }
}