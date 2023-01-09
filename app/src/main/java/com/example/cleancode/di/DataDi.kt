package com.example.cleancode.di

import com.example.data.repository.UserRepositoryImpl
import com.example.data.storage.UserStorage
import com.example.data.storage.sharedPrefs.SharedPrefUserStoreage
import com.example.domain.UserRepository
import com.example.domain.usecase.GetUserNameUseCase
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage>{
        SharedPrefUserStoreage(context = get())
    }
    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}