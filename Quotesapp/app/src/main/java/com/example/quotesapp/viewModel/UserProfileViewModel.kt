package com.example.quotesapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quotesapp.data.model.UserProfile
import com.example.quotesapp.domain.UseCase.GetUserProfileUseCase

class UserProfileViewModel(val userProfileUseCase: GetUserProfileUseCase): ViewModel() {


    val username = MutableLiveData<String>()


    init {

        getUsername()

    }
    fun getUsername(): UserProfile?{
        return userProfileUseCase.getUser().value
    }

//    fun fetchUserProfile(): LiveData<UserProfile> {
//        return userProfileUseCase.getUser()
//    }
}