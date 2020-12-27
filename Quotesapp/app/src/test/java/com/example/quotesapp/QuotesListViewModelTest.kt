package com.example.quotesapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule

import com.example.quotesapp.FakeRepository
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.viewModel.QuotesListViewModel
import com.example.quotesapp.viewModel.TagsListViewModel
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers.hasItem
import org.junit.Test

import org.junit.Before
import org.junit.Rule


class QuotesListViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: TagsListViewModel
    private lateinit var fakeUseCase: FakeUseCase
    private lateinit var fakeRepo: FakeRepository

    @Before
    fun setup() {
        fakeRepo = FakeRepository()
        fakeUseCase = FakeUseCase(fakeRepo)
        viewModel = TagsListViewModel(fakeUseCase)
    }

    @Test
    fun fetchRepoList() {
        val tag = Tags(1, 2, "aaa.com.kz", "NewTag")
        fakeRepo.insertTag(tag)
        val allData = viewModel.fetchTagsList()
        MatcherAssert.assertThat(allData.value, hasItem(tag))
    }
}