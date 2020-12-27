package com.example.quotesapp.LocalDatabase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.quotesapp.data.LocalDatabase.TagsDao
import com.example.quotesapp.data.LocalDatabase.TagsDatabase
import com.example.quotesapp.data.model.Tags
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class TagsDaoTests {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: TagsDatabase
    private lateinit var dao: TagsDao


    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TagsDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.tagDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertArticle() = runBlockingTest {
        val tagItem = Tags(1, 1, "www.ali.com", "NewTag")
        dao.insert(tagItem)

        val allTags = dao.getAll()
        MatcherAssert.assertThat(allTags, CoreMatchers.hasItem(tagItem))
    }

    @Test
    fun insertAllArticle() = runBlockingTest {
        val tagItem = Tags(1, 1, "www.ali.com", "NewTag")
        val tagItem2 = Tags(2, 2, "www.ali2.com", "NewTag2")
        val list = ArrayList<Tags>()
        list.add(tagItem)
        list.add(tagItem2)
        dao.insertAll(list)

        val allTags = dao.getAll()
        MatcherAssert.assertThat(allTags, CoreMatchers.hasItems(tagItem, tagItem2))
    }
}