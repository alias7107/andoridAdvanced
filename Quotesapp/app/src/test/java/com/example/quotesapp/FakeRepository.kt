package com.example.quotesapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.example.quotesapp.data.model.Item
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.domain.Repository.QuoteListRepository
import com.example.quotesapp.domain.Repository.TagsListRepository
import retrofit2.Response

class FakeRepository : TagsListRepository {
    var arrayList = mutableListOf<Tags>()
    var observableTags = MutableLiveData<List<Tags>>(arrayList)

    private fun refreshLiveData() {
        observableTags.postValue(arrayList)
    }

    fun insertTag(tags: Tags) {
        arrayList.add(tags)
        refreshLiveData()
    }

    override fun TagsData(): LiveData<List<Tags>> {
        return observableTags
    }


}