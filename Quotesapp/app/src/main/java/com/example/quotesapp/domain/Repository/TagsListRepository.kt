package com.example.quotesapp.domain.Repository

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.data.model.Tags

interface TagsListRepository {
    fun TagsData(): LiveData<List<Tags>>
}