package com.example.quotesapp.data.model

import com.google.gson.annotations.SerializedName


data class LoginResponse (
    @SerializedName("User-Token") var user_token: String,
    var login: String,
    var email: String,
    var message: String?


)

