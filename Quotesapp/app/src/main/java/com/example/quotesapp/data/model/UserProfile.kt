package com.example.quotesapp.data.model

import com.google.gson.annotations.SerializedName

data class UserProfile (
    var login: String,
    var pic_url: String,
    var pulic_favorites_count: Int,
var followers: Int,
var following: Int,
var account_details: Detail)


data class Detail(
    var email: String
)