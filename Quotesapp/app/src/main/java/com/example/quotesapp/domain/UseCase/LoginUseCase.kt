package com.example.quotesapp.domain.UseCase

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.LoginData
import com.example.quotesapp.data.model.LoginResponse
import com.example.quotesapp.domain.Repository.AccountRepository

class LoginUseCase(val accountRepository: AccountRepository)
{
    fun Login(data: LoginData): LiveData<LoginResponse> {
        return accountRepository.validateWithLogin(data)
    }
}
