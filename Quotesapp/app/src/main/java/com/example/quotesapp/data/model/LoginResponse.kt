package com.example.quotesapp.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("User-Token") val user_token: String,
    val login: String,
    val email: String
)
