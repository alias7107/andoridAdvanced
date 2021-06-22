package com.example.quotesapp.domain.UseCase

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.domain.Repository.GetTagsListUseCaseInterface
import com.example.quotesapp.domain.Repository.TagsListRepository

class GetTagsListUseCase(val tagsListRepository: TagsListRepository): GetTagsListUseCaseInterface {
    override fun getTagsList(): LiveData<List<Tags>> {
        return tagsListRepository.TagsData()
    }
}