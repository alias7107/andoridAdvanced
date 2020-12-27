package com.example.quotesapp.domain

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.data.model.Tags

class GetTagsListUseCase(val tagsListRepository: TagsListRepository): GetTagsListUseCaseInterface {
    override fun getTagsList(): LiveData<List<Tags>> {
        return tagsListRepository.TagsData()
    }
}