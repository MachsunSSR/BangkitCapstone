package com.bangkit.ambroise.core.data.remote.network

import com.bangkit.ambroise.core.data.remote.request.LoginRequest
import com.bangkit.ambroise.core.data.remote.request.UserRequest
import com.bangkit.ambroise.core.data.remote.response.LoginResponse
import com.bangkit.ambroise.core.data.remote.response.UserResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @POST("users")
    suspend fun register(@Body user: UserRequest): UserResponse

    @PUT("users/{userId}")
    suspend fun updateUser(
        @Header("Authorization") token: String,
        @Path("userId") userId: Int,
        @Body user: UserRequest
    ): UserResponse

    @POST("auth/local")
    suspend fun login(@Body login: LoginRequest): LoginResponse
}