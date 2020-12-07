package com.example.quotesapp.data.model

data class LoginData (
    var user: User
)


data class User(
    var login: String,
    var password: String
)