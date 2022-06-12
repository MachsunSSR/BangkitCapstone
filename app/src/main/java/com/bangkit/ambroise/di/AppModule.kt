package com.bangkit.ambroise.di

import com.bangkit.ambroise.core.domain.usecase.BarbershopInteractor
import com.bangkit.ambroise.core.domain.usecase.UserUseCase
import com.bangkit.ambroise.ui.auth.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<UserUseCase> { BarbershopInteractor(get()) }
}

val viewModelModule = module {
    viewModel { AuthViewModel(get()) }
}