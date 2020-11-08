package com.example.paginglibrary.data.model


data class MovieResponse (
    val page: Int,
    val total_pages: Int,
    val results: List<Item>? = null
)

data class Item(
    var id: Int,
    var vote_count: Int,
    var title: String,
    var vote_average: String,
    var poster_path: String,
    var release_date: String,
    var popularity: String,
    var budget: Int,
    var overview: String
)