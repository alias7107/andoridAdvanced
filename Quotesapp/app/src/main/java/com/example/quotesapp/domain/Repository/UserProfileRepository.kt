package com.example.quotesapp.domain.Repository

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.data.model.UserProfile

interface UserProfileRepository {
    fun loadUser(): LiveData<UserProfile>
}