package com.example.expertsubs.di

import com.example.expertsubs.core.domain.usecase.UserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {

    fun userUseCase(): UserUseCase
}