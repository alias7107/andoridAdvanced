package com.example.quotesapp.data.repository

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.data.model.LoginData
import com.example.quotesapp.data.model.LoginResponse
import com.example.quotesapp.domain.AccountRepository
import com.example.quotesapp.domain.QuoteListRepository

class LoginDataStore (apiService: ApiService): AccountRepository, BaseLoginDataStore(apiService) {


    override fun validateWithLogin(data: LoginData): LiveData<LoginResponse> {
        return authenticate { service.validateWithLogin(data) }
    }





}