package com.example.quotesapp.domain

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.data.model.UserProfile

class GetUserProfileUseCase (val userProfileRepository: UserProfileRepository) {
    fun getUser(): LiveData<UserProfile> {
        return userProfileRepository.loadUser()
    }
}