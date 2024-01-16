package com.example.expertsubs.di

import com.example.expertsubs.core.domain.usecase.UserInteractor
import com.example.expertsubs.core.domain.usecase.UserUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideTourismUseCase(userInteractor: UserInteractor): UserUseCase
}