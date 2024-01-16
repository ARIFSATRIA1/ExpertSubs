package com.example.expertsubs.core.data.source.local

import androidx.lifecycle.LiveData
import com.example.expertsubs.core.data.source.local.entity.UserEntity
import com.example.expertsubs.core.data.source.local.room.UserDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val userDao: UserDao){


    fun getAllAnime(): Flow<List<UserEntity>>  = userDao.getAllAnime()

    fun getFavoriteAnime(): Flow<List<UserEntity>> = userDao.getFavoriteAnime()

    fun insertTourism(animeList: List<UserEntity>) = userDao.insertAnime(animeList)

    fun setFavoriteAnime(userEntity: UserEntity, newState: Boolean) {
        userEntity.isFavorite = newState
        userDao.updateFavoriteTourism(userEntity)
    }

}