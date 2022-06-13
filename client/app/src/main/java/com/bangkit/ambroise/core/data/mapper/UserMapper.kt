package com.bangkit.ambroise.core.data.mapper

import com.bangkit.ambroise.core.data.remote.response.LoginResponse
import com.bangkit.ambroise.core.data.remote.response.UserResponse
import com.bangkit.ambroise.core.domain.entity.Login
import com.bangkit.ambroise.core.domain.entity.User
import com.bangkit.ambroise.util.orFalse
import com.bangkit.ambroise.util.orZero
import kotlinx.coroutines.flow.flowOf

object UserMapper {
    fun mapDataToDomain(from: LoginResponse) = flowOf(
        Login(
            token = from.jwt.orEmpty(),
            user = mapUser(
                from.user ?: UserResponse()
            )
        )
    )

    fun mapDataToDomain(from: UserResponse) = flowOf(
        mapUser(
            from
        )
    )

    private fun mapUser(from: UserResponse) = User(
        id = from.id.orZero(),
        username = from.username.orEmpty(),
        email = from.email.orEmpty(),
        provider = from.provider.orEmpty(),
        confirmed = from.blocked.orFalse(),
        blocked = from.blocked.orFalse(),
        createdAt = from.createdAt.orEmpty(),
        updatedAt = from.updatedAt.orEmpty()
    )
}
