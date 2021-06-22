package com.example.quotesapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.domain.Repository.GetTagsListUseCaseInterface
import com.example.quotesapp.domain.UseCase.GetTagsListUseCase

class TagsListViewModel(private val getTagsListUseCase: GetTagsListUseCase): BaseViewModel() {
    private var tagsList = MutableLiveData<List<Tags>>()

    init {
        fetchTagsList()
    }
    fun fetchTagsList() {
        tagsList = getTagsListUseCase.getTagsList() as MutableLiveData<List<Tags>>

    }

    fun getTagsList(): LiveData<List<Tags>> {
        return tagsList
    }
}