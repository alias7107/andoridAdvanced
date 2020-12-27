package com.example.quotesapp.viewModel

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.domain.GetQuoteListUseCase
import com.example.quotesapp.domain.GetTagsListUseCase
import com.example.quotesapp.domain.GetTagsListUseCaseInterface

class TagsListViewModel(private val getTagsListUseCase: GetTagsListUseCaseInterface): BaseViewModel() {
    fun fetchTagsList(): LiveData<List<Tags>> {
        return getTagsListUseCase.getTagsList()
    }
}