package com.example.expertsubs.core.data.source



import com.example.expertsubs.core.data.source.local.LocalDataSource
import com.example.expertsubs.core.data.source.remote.RemoteDataSource
import com.example.expertsubs.core.data.source.remote.network.ApiResponse
import com.example.expertsubs.core.data.source.remote.response.ItemsItem
import com.example.expertsubs.core.domain.model.Users
import com.example.expertsubs.core.domain.repository.IUserRepository
import com.example.expertsubs.core.utils.AppExecutors
import com.example.expertsubs.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IUserRepository{
    override fun getAllUser(): Flow<Resource<List<Users>>> =
        object : NetworkBoundResources<List<Users>, List<ItemsItem>>() {
            override fun loadFromDB(): Flow<List<Users>> {
                return localDataSource.getAllAnime().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ItemsItem>>> {
                return remoteDataSource.getAllUser()
            }

            override suspend fun saveCallResult(data: List<ItemsItem>) {
                val userList = DataMapper.mapResponsesToEntities(data)
                appExecutors.diskIO().execute{localDataSource.insertTourism(userList)}
            }

            override fun shouldFetch(data: List<Users>?): Boolean {
               data == null || data.isNotEmpty()
                return true
            }
        }.asFlow()


    override fun getFavoriteUser(): Flow<List<Users>> {
        return localDataSource.getFavoriteAnime().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteUser(users: Users, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(users)
        appExecutors.diskIO().execute{localDataSource.setFavoriteAnime(tourismEntity, state)}
    }


}