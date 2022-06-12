package com.bangkit.ambroise.core.data.remote

import android.util.Log
import com.bangkit.ambroise.core.data.remote.network.ApiResponse
import com.bangkit.ambroise.core.data.remote.network.ApiService
import com.bangkit.ambroise.core.data.remote.request.LoginRequest
import com.bangkit.ambroise.core.data.remote.request.UserRequest
import com.bangkit.ambroise.core.data.remote.response.LoginResponse
import com.bangkit.ambroise.core.data.remote.response.UserResponse
import com.bangkit.ambroise.util.toBearerToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun register(user: UserRequest): Flow<ApiResponse<UserResponse>> = flow {
        try {
            val response = apiService.register(user)

            emit(ApiResponse.Success(response))
        } catch (e: Exception) {
            emit(ApiResponse.Error(e.message))
            errorLog(e)
        }
    }.flowOn(Dispatchers.IO)

    suspend fun updateUser(
        token: String,
        userId: Int,
        user: UserRequest
    ): Flow<ApiResponse<UserResponse>> = flow {
        try {
            val response = apiService.updateUser(token.toBearerToken(), userId, user)

            emit(ApiResponse.Success(response))
        } catch (e: Exception) {
            emit(ApiResponse.Error(e.message))
            errorLog(e)
        }
    }.flowOn(Dispatchers.IO)

    suspend fun login(login: LoginRequest): Flow<ApiResponse<LoginResponse>> = flow {
        try {
            val response = apiService.login(login)

            emit(ApiResponse.Success(response))
        } catch (e: Exception) {
            emit(ApiResponse.Error(e.message))
            errorLog(e)
        }
    }.flowOn(Dispatchers.IO)

    private fun errorLog(e: Exception) =
        Log.e(RemoteDataSource::class.java.simpleName, e.toString())

}