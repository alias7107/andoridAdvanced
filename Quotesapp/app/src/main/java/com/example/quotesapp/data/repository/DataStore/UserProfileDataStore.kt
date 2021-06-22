package com.example.quotesapp.data.repository.DataStore

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.model.UserProfile
import com.example.quotesapp.data.repository.Base.BaseProfileDataStore
import com.example.quotesapp.domain.Repository.UserProfileRepository

class UserProfileDataStore (apiService: ApiService): UserProfileRepository, BaseProfileDataStore(apiService) {
    override fun loadUser(): LiveData<UserProfile> {
        return fetchUser { service.getUserProfile("ashkeyevli") }
    }

}