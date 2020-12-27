package com.example.quotesapp.domain

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.quotesapp.R
import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.model.LoginData
import com.example.quotesapp.data.model.LoginResponse
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.utils.Constants.Companion.DEFAULT_VALUE

class LoginUseCase(val accountRepository: AccountRepository)
{
    fun Login(data: LoginData): LiveData<LoginResponse> {
        return accountRepository.validateWithLogin(data)
    }
}
