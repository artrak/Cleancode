package com.example.cleancode.di

import com.example.cleancode.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        MainViewModel(
            getUserNameUserCase = get(),
            saveUserNameUseCase = get()
        )
    }
}