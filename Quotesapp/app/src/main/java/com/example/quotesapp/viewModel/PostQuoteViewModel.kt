package com.example.quotesapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quotesapp.data.model.*
import com.example.quotesapp.domain.LoginUseCase
import com.example.quotesapp.domain.PostQuoteUseCase

class PostQuoteViewModel(val postQuoteUseCase: PostQuoteUseCase): ViewModel() {


    fun PostQuote(author: String, body: String): LiveData<Quote> {
        return postQuoteUseCase.PostQuote(Quote(QuoteItem( author, body)))

    }
}