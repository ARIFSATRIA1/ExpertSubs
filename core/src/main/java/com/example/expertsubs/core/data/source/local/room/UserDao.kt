package com.example.expertsubs.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.expertsubs.core.data.source.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAllAnime(): Flow<List<UserEntity>>

    @Query("SELECT * FROM user WHERE isFavorite = 1")
    fun getFavoriteAnime(): Flow<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAnime(anime: List<UserEntity>)

    @Update
    fun updateFavoriteTourism(anime: UserEntity)

}