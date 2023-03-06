package com.example.onlineshop.core.data.storage.database

import android.content.Context
import javax.inject.Inject

class UserSharedPref @Inject constructor(context: Context) {

    private val preferences = context.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)

    var userName: String?
        get() {
            return preferences.getString(USER_NAME, null)
        }
        set(value) {
            value?.let {
                preferences.edit()
                    .putString(USER_NAME, it)
                    .apply()
            }
        }

    private companion object {
        private const val USER_NAME = "user_name"
    }
}