package com.example.expertsubs.core.domain.usecase


import com.example.expertsubs.core.domain.model.Users
import com.example.expertsubs.core.domain.repository.IUserRepository
import javax.inject.Inject

class UserInteractor @Inject constructor(private val userRepository: IUserRepository): UserUseCase {
    override fun getAllUser() = userRepository.getAllUser()

    override fun getFavoriteUser() = userRepository.getFavoriteUser()

    override fun setFavoriteUser(users: Users, state: Boolean) = userRepository.setFavoriteUser(users, state)


}