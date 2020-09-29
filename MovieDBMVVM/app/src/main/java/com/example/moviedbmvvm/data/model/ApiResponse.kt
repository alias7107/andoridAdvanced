package com.example.moviedbmvvm.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse (
val results: List<Item>

)

data class Item(

    var id: Int,
    var vote_count: Int,
    var title: String,
    var vote_average: String,
    var poster_path: String,
    var release_date: String,
    var popularity: String,
    var runtime: Int,
    var budget: Int,
    var revenue: Int,
    var overview: String

)