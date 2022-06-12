package com.bangkit.ambroise.core.domain.usecase

import com.bangkit.ambroise.core.data.Resource
import com.bangkit.ambroise.core.data.remote.request.LoginRequest
import com.bangkit.ambroise.core.data.remote.request.UserRequest
import com.bangkit.ambroise.core.domain.entity.Login
import com.bangkit.ambroise.core.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface UserUseCase {
    fun login(login: LoginRequest) : Flow<Resource<Login>>

    fun register(user: UserRequest) : Flow<Resource<User>>

    fun updateUser(token: String, userId: Int, user: UserRequest): Flow<Resource<User>>

    fun getLoginCache() : Flow<Login>

    suspend fun logout()
}