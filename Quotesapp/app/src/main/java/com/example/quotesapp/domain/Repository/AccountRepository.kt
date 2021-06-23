package com.example.quotesapp.domain.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.LoginData
import com.example.quotesapp.data.model.LoginResponse


interface AccountRepository {
   fun validateWithLogin(data: LoginData): LiveData<LoginResponse>
}