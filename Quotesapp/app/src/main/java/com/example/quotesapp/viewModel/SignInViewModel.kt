package com.example.quotesapp.viewModel

import android.util.Log
import androidx.lifecycle.*
import com.example.quotesapp.data.model.*
import com.example.quotesapp.domain.LoginUseCase

open class SignInViewModel(val loginUseCase: LoginUseCase): ViewModel() {

    var state = MutableLiveData<SignInState>()
    var message = MutableLiveData<String>()

    fun signIn(login: String, password: String): LiveData<LoginResponse> {
        state.value = SignInState.ShowLoading
        val result = loginUseCase.Login(LoginData(User(login, password)))

        val ss = Observer<LoginResponse> { loginResponse ->
            if (loginResponse.message ==null) {

                state.value = SignInState.Result
                state.value = SignInState.HideLoading
            } else {
                state.value = SignInState.FailedLoading
                state.value = SignInState.HideLoading
                message.value = loginResponse.message
            }
            result.removeObserver({})
        }

        result.observeForever(ss)
        return result

    }

}