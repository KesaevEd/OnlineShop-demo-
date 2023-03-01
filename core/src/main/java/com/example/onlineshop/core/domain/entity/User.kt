package com.example.onlineshop.core.domain.entity

import android.net.Uri

data class User(
    val id: Int? = null,
    val name: String? = null,
    val lastname: String? = null,
    val email: String? = null,
    val password: String? = null,
    val imageUri: Uri? = null
)
