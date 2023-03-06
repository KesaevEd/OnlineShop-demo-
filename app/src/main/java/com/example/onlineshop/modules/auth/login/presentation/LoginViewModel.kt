package com.example.onlineshop.modules.auth.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.core.data.storage.database.UserSharedPref
import com.example.onlineshop.core.domain.entity.User
import com.example.onlineshop.domain.UserRepository
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class LoginViewModel @AssistedInject constructor(
    private val userRepository: UserRepository,
    private val userSharedPref: UserSharedPref
): ViewModel() {

    private val isUserExists = MutableLiveData<Boolean>()
    val isUserExistLiveData:LiveData<Boolean> = isUserExists

    fun checkUserExists(userName: String){
        viewModelScope.launch {
            isUserExists.value = userRepository.checkUserExist(userName)
        }
    }

    fun saveUserName(username: String){
        userSharedPref.userName = username
    }


    @AssistedFactory
    interface Factory{
        fun create(): LoginViewModel
    }
}