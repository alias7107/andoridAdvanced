package com.example.quotesapp.data.repository

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.data.model.UserProfile
import com.example.quotesapp.domain.TagsListRepository
import com.example.quotesapp.domain.UserProfileRepository

class UserProfileDataStore (apiService: ApiService): UserProfileRepository, BaseProfileDataStore(apiService) {
    override fun loadUser(): LiveData<UserProfile> {
        return fetchUser { service.getUserProfile("ashkeyevli") }
    }

}