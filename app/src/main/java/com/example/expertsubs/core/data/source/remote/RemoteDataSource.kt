package com.example.expertsubs.core.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.expertsubs.core.data.source.remote.network.ApiResponse
import com.example.expertsubs.core.data.source.remote.network.ApiService
import com.example.expertsubs.core.data.source.remote.response.ItemsItem
import com.example.expertsubs.core.data.source.remote.response.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {


    suspend fun getAllUser(): Flow<ApiResponse<List<ItemsItem>>> {

        return flow {
            try {
                val response = apiService.getUsersData()
                val dataArray = response.items
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    }


}