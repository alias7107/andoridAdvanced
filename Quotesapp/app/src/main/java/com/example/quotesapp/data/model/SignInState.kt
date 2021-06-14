package com.example.quotesapp.data.model

sealed class SignInState {
    object ShowLoading: SignInState()
    object HideLoading: SignInState()
    object FailedLoading: SignInState()
    object Result: SignInState()
}