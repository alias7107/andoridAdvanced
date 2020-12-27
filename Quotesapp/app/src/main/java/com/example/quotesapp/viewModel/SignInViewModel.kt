package com.example.quotesapp.viewModel

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quotesapp.data.model.*
import com.example.quotesapp.domain.AccountRepository
import com.example.quotesapp.domain.GetQuoteListUseCase
import com.example.quotesapp.domain.GetTagsListUseCase
import com.example.quotesapp.domain.LoginUseCase
import kotlinx.coroutines.launch

open class SignInViewModel(val loginUseCase: LoginUseCase): ViewModel() {


    var userSession = MutableLiveData<LoginResponse>()
    var errorUserSession = MutableLiveData<String>()

    fun signIn(login: String, password: String): LiveData<LoginResponse> {

        return loginUseCase.Login(LoginData(User(login, password)))

    }
}