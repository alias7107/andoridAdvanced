package com.example.quotesapp.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.domain.QuoteListRepository
import com.example.quotesapp.domain.TagsListRepository

class TagsListDataStore(apiService: ApiService, context: Context): TagsListRepository, BaseTagDataStore(apiService, context) {
      override fun TagsData(): LiveData<List<Tags>> {
        return fetchTags { service.getTagsList() }
    }

}