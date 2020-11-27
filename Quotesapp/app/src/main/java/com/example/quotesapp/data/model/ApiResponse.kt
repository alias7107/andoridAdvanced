package com.example.quotesapp.data.model

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
    var body: String
)

data class TypeHeadResponse (
    val tags: List<Tags>
)

data class Tags(
    var id: Int,
    var count: Int,
    var permalink: String,
    var name: String
)