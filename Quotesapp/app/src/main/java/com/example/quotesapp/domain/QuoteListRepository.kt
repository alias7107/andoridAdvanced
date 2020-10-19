package com.example.quotesapp.domain

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Item

interface QuoteListRepository {
    fun loadData(): LiveData<List<Item>>

}