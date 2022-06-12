package com.bangkit.ambroise.core.domain.usecase

import com.bangkit.ambroise.core.data.Resource
import com.bangkit.ambroise.core.data.remote.request.LoginRequest
import com.bangkit.ambroise.core.data.remote.request.UserRequest
import com.bangkit.ambroise.core.domain.entity.User
import com.bangkit.ambroise.core.domain.repository.IUserRepository
import kotlinx.coroutines.flow.Flow

class BarbershopInteractor(private val userRepository: IUserRepository) : UserUseCase {

    override fun login(login: LoginRequest) = userRepository.login(login)

    override fun register(user: UserRequest) = userRepository.register(user)

    override fun updateUser(token: String, userId: Int, user: UserRequest) =
        userRepository.updateUser(token, userId, user)

    override fun getLoginCache() = userRepository.getLoginCache()

    override suspend fun logout() = userRepository.logout()
}