package com.example.onlineshop.modules.auth.signin.presentation

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

class SignInViewModel @AssistedInject constructor(
    private val userRepository: UserRepository,
    private val userSharedPref: UserSharedPref
) : ViewModel() {

    private val user = MutableLiveData<User>()
    val userLiveData: LiveData<User> = user

    private val isUserSaved = MutableLiveData<Boolean>()
    val isUserSavedLiveData: LiveData<Boolean> = isUserSaved


    fun saveNewUser() {
        viewModelScope.launch {
            user.value?.let { user ->
                if (userRepository.checkUserExist(user.name)) {
                    isUserSaved.value = false
                }else{
                    userRepository.saveUserToDb(user)
                    isUserSaved.value = true
                }
            }
        }
    }

    fun saveUserName(username: String){
        userSharedPref.userName = username
    }

    fun setNewUser(){
        if(user.value == null){
            user.value = User()
        }
    }

    fun setNewUserData(
        name: String? = null,
        lastName: String? = null,
        email: String? = null
    ) {
        user.value?.copy(
            name = name ?: user.value!!.name,
            lastname = lastName ?: user.value!!.lastname,
            email = email ?: user.value!!.email
        )?.let {
            user.value = it
        }
    }

    @AssistedFactory
    interface Factory{
        fun create(): SignInViewModel
    }
}