package com.example.onlineshop.modules.profile.presentation

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.core.domain.entity.User
import com.example.onlineshop.modules.auth.domain.UserRepository
import com.example.onlineshop.modules.auth.signin.presentation.SignInViewModel
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class ProfileViewModel @AssistedInject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    private val user = MutableLiveData<User>()
    val userLiveData: LiveData<User> = user

    fun setNewUser(newUser: User){
        Log.d("observe", "setNewUser  = $newUser")
        viewModelScope.launch {
            user.value = newUser
        }
    }

    fun setNewUserByName(userName: String?){
        Log.d("observe", "setNewUserByName  name = $userName")
        viewModelScope.launch {
            val newUser = userRepository.getUserByName(userName)
            user.value = newUser
            Log.d("observe", "setNewUserByName    user.value  = ${user.value}")
        }
    }

    fun setNewUserAvatar(
        imageUri: Uri? = null
    ) {
        viewModelScope.launch {
            user.value?.copy(
                imageUri = imageUri ?: user.value!!.imageUri,
            )?.let {
                user.value = it
                userRepository.updateImageUri(it.name, it.imageUri!!)
            }
        }
    }

    @AssistedFactory
    interface Factory{
        fun create(): ProfileViewModel
    }
}