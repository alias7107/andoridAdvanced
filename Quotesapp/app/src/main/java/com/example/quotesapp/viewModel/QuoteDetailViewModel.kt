package com.example.quotesapp.viewModel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.domain.UseCase.GetQuoteListUseCase
import com.example.quotesapp.domain.UseCase.GetQuoteUseCase

class QuoteDetailViewModel (val getQuoteUseCase: GetQuoteUseCase): BaseViewModel() {
    private var quoteDetail = MutableLiveData<Item>()



    fun getQuote(quote_id: Int): LiveData<Item> {
        return getQuoteUseCase.getQuote(quote_id)
    }

    fun favQuote(quote_id: Int): LiveData<Item>{
        return getQuoteUseCase.favQuote(quote_id)
    }
    fun unfavQuote(quote_id: Int): LiveData<Item>{
        return getQuoteUseCase.unfavQuote(quote_id)
    }
}