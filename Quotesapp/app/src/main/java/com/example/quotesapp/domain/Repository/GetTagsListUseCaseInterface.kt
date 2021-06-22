package com.example.quotesapp.domain.Repository

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Tags

interface GetTagsListUseCaseInterface {
    fun getTagsList(): LiveData<List<Tags>>
}