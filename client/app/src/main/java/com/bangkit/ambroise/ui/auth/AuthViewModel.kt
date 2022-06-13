package com.bangkit.ambroise.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bangkit.ambroise.core.data.remote.request.LoginRequest
import com.bangkit.ambroise.core.data.remote.request.UserRequest
import com.bangkit.ambroise.core.domain.usecase.UserUseCase
import kotlinx.coroutines.launch

class AuthViewModel(private val userUseCase: UserUseCase) :
    ViewModel() {

    fun register(user: UserRequest) = userUseCase.register(user).asLiveData()

    fun login(login: LoginRequest) = userUseCase.login(login).asLiveData()

    fun updateUser(token: String, userId: Int, user: UserRequest) =
        userUseCase.updateUser(token, userId, user).asLiveData()

    fun getLoginCache() = userUseCase.getLoginCache().asLiveData()

    fun logout() = viewModelScope.launch { userUseCase.logout() }

}