package com.example.quotesapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class TypeHeadResponse (
    val tags: List<Tags>
)
@Entity(tableName = "Tags_table")
data class Tags(
    var id: Int,
    @ColumnInfo(name = "count")
    var count: Int,

    @ColumnInfo(name = "permalink")
    @PrimaryKey
    var permalink: String,
    @ColumnInfo(name = "name")
    var name: String
)

data class QuoteResponse (
    val quotes: List<Item>
)

data class Item(

    var id: Int,
    var tags: List<String>,
    var url: String,
    var favorites_count: String,
    var upvotes_count: String,
    var downvotes_count: String,
    var author: String,
    var body: String,
    var favourite: Boolean,
    var user_details: UserDetails
)

data class UserDetails(
    var favorite: Boolean,
    var upvote: Boolean,
    var downvote: Boolean,
    var hidden: Boolean,
)

data class Quote(
    var quote: QuoteItem
)

data class QuoteItem(
    var author: String,
    var body: String

)
