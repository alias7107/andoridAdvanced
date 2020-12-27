package com.example.quotesapp.domain

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Tags

interface GetTagsListUseCaseInterface {
    fun getTagsList(): LiveData<List<Tags>>
}