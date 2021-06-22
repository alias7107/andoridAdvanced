package com.example.quotesapp.domain.UseCase

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.UserProfile
import com.example.quotesapp.domain.Repository.UserProfileRepository

class GetUserProfileUseCase (val userProfileRepository: UserProfileRepository) {
    fun getUser(): LiveData<UserProfile> {
        return userProfileRepository.loadUser()
    }
}