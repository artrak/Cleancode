package com.example.cleancode.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.repository.UserRepositoryImpl
import com.example.data.storage.sharedPrefs.SharedPrefUserStoreage
import com.example.domain.models.SaveUserNameParam
import com.example.domain.models.UserName
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase

class MainViewModel(
        private val getUserNameUserCase: GetUserNameUseCase,
        private val saveUserNameUseCase: SaveUserNameUseCase
    ) : ViewModel() {

    private var resultLive = MutableLiveData<String>()
    fun getResultLive(): LiveData<String>{
        return resultLive
    }

    init {
        Log.d("AAA", "VM created")
    }

    override fun onCleared() {
        Log.d("AAA", "VM created")
        super.onCleared()
    }

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(params)
        resultLive.value = "Save result = $resultData"
    }
    fun load() {
        val userName: UserName = getUserNameUserCase.execute()
        resultLive.value = "${userName.firstName} ${userName.lastName}"
    }
}