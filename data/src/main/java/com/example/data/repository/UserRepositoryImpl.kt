package com.example.data.repository

import com.example.domain.models.SaveUserNameParam
import com.example.domain.models.UserName
import com.example.domain.UserRepository
import com.example.data.storage.models.User
import com.example.data.storage.UserStorage

class UserRepositoryImpl(private val userStorage: UserStorage):
    UserRepository {


    override fun saveName(saveparam: SaveUserNameParam): Boolean{

        return userStorage.save(
            mapToStorage(saveparam)
        )
    }

    override fun getName(): UserName{
        val user = userStorage.get()

        val userName = mapToDomain(user = user)

        return userName
    }

    private fun mapToStorage(saveparam: SaveUserNameParam): User{
        return User(
            firstName = saveparam.name,
            lastName = ""
        )
    }

    private fun mapToDomain(user: User): UserName{
        return UserName(
            firstName = user.firstName,
            lastName = user.lastName
        )
    }
}