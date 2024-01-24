package com.example.expertsubs.favorite.fav

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.expertsubs.core.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class FavoriteViewModel(userUseCase: UserUseCase): ViewModel() {
    val favoriteUser = userUseCase.getFavoriteUser().asLiveData()
}