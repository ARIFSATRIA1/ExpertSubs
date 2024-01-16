package com.example.expertsubs.core.domain.usecase

import androidx.lifecycle.LiveData
import com.example.expertsubs.core.data.source.Resource
import com.example.expertsubs.core.domain.model.Users
import kotlinx.coroutines.flow.Flow


interface UserUseCase {
    fun getAllUser(): Flow<Resource<List<Users>>>

    fun getFavoriteUser(): Flow<List<Users>>

    fun setFavoriteUser(users: Users, state: Boolean)
}