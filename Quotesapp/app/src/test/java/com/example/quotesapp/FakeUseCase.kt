package com.example.quotesapp

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.domain.Repository.GetTagsListUseCaseInterface

import com.example.quotesapp.domain.Repository.QuoteListRepository
import com.example.quotesapp.domain.Repository.TagsListRepository

class FakeUseCase(val tagsListRepository: TagsListRepository): GetTagsListUseCaseInterface {
    override fun getTagsList(): LiveData<List<Tags>> {
        return tagsListRepository.TagsData()
    }
}