package com.example.onlineshop.base

import android.app.Application
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.onlineshop.App
import com.example.onlineshop.di.components.AppComponent


inline fun <reified T : ViewModel> Fragment.lazyViewModel(
    noinline create: (stateHandle: SavedStateHandle) -> T
) = viewModels<T> {
    Factory(this, create)
}

fun Fragment.showToast(stringRes: Int) {
    Toast.makeText(this.requireContext(), stringRes, Toast.LENGTH_SHORT).show()
}