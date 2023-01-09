package com.example.cleancode.di

import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetUserNameUseCase(userRepository = get())
    }
    factory {
        SaveUserNameUseCase(userRepository = get())
    }
}