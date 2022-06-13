package com.bangkit.ambroise.core.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.bangkit.ambroise.core.data.NetworkOnlyResource
import com.bangkit.ambroise.core.data.Resource
import com.bangkit.ambroise.core.data.mapper.UserMapper.mapDataToDomain
import com.bangkit.ambroise.core.data.remote.RemoteDataSource
import com.bangkit.ambroise.core.data.remote.network.ApiResponse
import com.bangkit.ambroise.core.data.remote.request.LoginRequest
import com.bangkit.ambroise.core.data.remote.request.UserRequest
import com.bangkit.ambroise.core.data.remote.response.LoginResponse
import com.bangkit.ambroise.core.data.remote.response.UserResponse
import com.bangkit.ambroise.core.domain.entity.Login
import com.bangkit.ambroise.core.domain.entity.User
import com.bangkit.ambroise.core.domain.repository.IUserRepository
import com.bangkit.ambroise.util.orZero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

const val DATASTORE_NAME = "USER_DATASTORE"
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(DATASTORE_NAME)

class UserRepository(private val context: Context, private val remoteDataSource: RemoteDataSource) :
    IUserRepository {

    override fun register(user: UserRequest) =
        object :
            NetworkOnlyResource<User, UserResponse>() {
            override suspend fun loadFromNetwork(data: UserResponse) =
                mapDataToDomain(data)

            override suspend fun createCall() = remoteDataSource.register(user)
        }.asFlow()

    override fun login(loginRequest: LoginRequest) =
        object :
            NetworkOnlyResource<Login, LoginResponse>() {
            override suspend fun loadFromNetwork(data: LoginResponse): Flow<Login> {
                context.dataStore.edit { login ->
                    login[USER_ID] = data.user?.id.toString()
                    login[USER_EMAIL] = data.user?.email.orEmpty()
                    login[USER_NAME] = data.user?.username.orEmpty()
                    login[TOKEN] = data.jwt.orEmpty()
                }

                return mapDataToDomain(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<LoginResponse>> =
                remoteDataSource.login(loginRequest)
        }.asFlow()

    override fun updateUser(token: String, userId: Int, user: UserRequest) =
        object : NetworkOnlyResource<User, UserResponse>() {
            override suspend fun loadFromNetwork(data: UserResponse) = mapDataToDomain(data)

            override suspend fun createCall(): Flow<ApiResponse<UserResponse>> =
                remoteDataSource.updateUser(token, userId, user)

        }.asFlow()

    override fun getLoginCache() = context.dataStore.data.map { login ->
        Login(
            token = login[TOKEN].orEmpty(),
            user = User(
                id = login[USER_ID]?.toInt().orZero(),
                username = login[USER_NAME].orEmpty(),
                email = login[USER_EMAIL].orEmpty()
            )
        )
    }

    override suspend fun logout() {
        context.dataStore.edit { login ->
            login.apply {
                remove(TOKEN)
                remove(USER_EMAIL)
                remove(USER_NAME)
                remove(TOKEN)
            }
        }
    }

    companion object {
        val USER_ID = stringPreferencesKey("user_id")
        val USER_EMAIL = stringPreferencesKey("user_email")
        val USER_NAME = stringPreferencesKey("user_name")
        val TOKEN = stringPreferencesKey("token")
    }
}