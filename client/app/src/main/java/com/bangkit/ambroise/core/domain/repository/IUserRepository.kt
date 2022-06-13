package com.bangkit.ambroise.core.domain.repository

import com.bangkit.ambroise.core.data.Resource
import com.bangkit.ambroise.core.data.remote.request.LoginRequest
import com.bangkit.ambroise.core.data.remote.request.UserRequest
import com.bangkit.ambroise.core.domain.entity.Login
import com.bangkit.ambroise.core.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface IUserRepository {
    fun register(user: UserRequest): Flow<Resource<User>>

    fun login(loginRequest: LoginRequest): Flow<Resource<Login>>

    fun updateUser(token: String, userId: Int, user: UserRequest): Flow<Resource<User>>

    fun getLoginCache(): Flow<Login>

    suspend fun logout()
}