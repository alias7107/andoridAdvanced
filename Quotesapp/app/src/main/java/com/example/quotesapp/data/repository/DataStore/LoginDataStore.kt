package com.example.quotesapp.data.repository.DataStore

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.model.LoginData
import com.example.quotesapp.data.model.LoginResponse
import com.example.quotesapp.data.repository.Base.BaseLoginDataStore
import com.example.quotesapp.domain.Repository.AccountRepository

class LoginDataStore (apiService: ApiService, context: Context): AccountRepository, BaseLoginDataStore(apiService, context) {


    override fun validateWithLogin(data: LoginData): LiveData<LoginResponse> {
        return authenticate {service.validateWithLogin(data) }
    }





}