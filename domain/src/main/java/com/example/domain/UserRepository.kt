package com.example.domain

import com.example.domain.models.SaveUserNameParam
import com.example.domain.models.UserName

interface UserRepository {

    fun saveName(saveparam: SaveUserNameParam): Boolean

    fun getName(): UserName
}