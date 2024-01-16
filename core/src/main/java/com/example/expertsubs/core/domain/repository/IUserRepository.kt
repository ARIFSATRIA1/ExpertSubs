package com.example.expertsubs.core.domain.repository

import androidx.lifecycle.LiveData
import com.example.expertsubs.core.data.source.Resource
import com.example.expertsubs.core.domain.model.Users
import kotlinx.coroutines.flow.Flow

interface IUserRepository {

    fun getAllUser(): Flow<com.example.expertsubs.core.data.source.Resource<List<Users>>>

    fun getFavoriteUser(): Flow<List<Users>>

    fun setFavoriteUser(users: Users, state: Boolean)

}