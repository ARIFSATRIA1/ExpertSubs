package com.example.expertsubs.detail

import androidx.lifecycle.ViewModel
import com.example.expertsubs.core.domain.model.Users
import com.example.expertsubs.core.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val userUseCase: UserUseCase): ViewModel() {
    fun setFavoriteUser(users: Users, state: Boolean) {
        userUseCase.setFavoriteUser(users, state)
    }
}