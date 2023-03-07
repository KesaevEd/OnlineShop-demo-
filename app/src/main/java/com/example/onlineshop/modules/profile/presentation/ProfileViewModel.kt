package com.example.onlineshop.modules.profile.presentation

import android.net.Uri
import android.util.Log
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

class ProfileViewModel @AssistedInject constructor(
    private val userRepository: UserRepository,
    private val userSharedPref: UserSharedPref
): ViewModel() {

    private val user = MutableLiveData<User>()
    val userLiveData: LiveData<User> = user

    fun setNewUser(newUser: User){
        viewModelScope.launch {
            user.value = newUser
        }
    }

    fun setNewUserByName(){
        viewModelScope.launch {
            val name = userSharedPref.userName
            val newUser = userRepository.getUserByName(name)
            user.value = newUser
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