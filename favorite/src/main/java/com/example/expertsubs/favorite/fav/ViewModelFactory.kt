package com.example.expertsubs.favorite.fav

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.expertsubs.core.domain.usecase.UserUseCase
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val userUseCase: UserUseCase): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
         when {
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(userUseCase) as T
            } else -> {
                throw Throwable("Unknown ViewModel class: " + modelClass.name)
            }
        }


}