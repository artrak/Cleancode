package com.example.domain.usecase

import com.example.domain.models.SaveUserNameParam
import com.example.domain.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam) : Boolean{
        val result: Boolean = userRepository.saveName(saveparam = param)
        return !param.name.isEmpty()
    }
}