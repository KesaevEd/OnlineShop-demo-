package com.example.onlineshop.modules.auth.login.presentation

import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.onlineshop.App
import com.example.onlineshop.R
import com.example.onlineshop.base.lazyViewModel
import com.example.onlineshop.base.showToast
import com.example.onlineshop.databinding.FragmentLogInBinding
import com.example.onlineshop.modules.auth.di.DaggerAuthComponent

class LogInFragment : Fragment(R.layout.fragment_log_in) {

    private val binding by viewBinding(FragmentLogInBinding::bind)

    private val component = DaggerAuthComponent.builder().appComponent(App.component).build()

    private val viewModel by lazyViewModel { component.loginViewModel().create() }

    private var isPasswordHide = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.isUserExistLiveData.observe(viewLifecycleOwner) { isUserExists ->
            try {
                if (isUserExists) {
                    val name = binding.etFirstName.text.toString().trim()
                    viewModel.saveUserName(name)
                    findNavController().navigate(R.id.action_logInFragment_to_home)
                } else {
                    showToast(R.string.username_not_exists)
                }
            } catch (e: java.lang.Exception) {
                showToast(R.string.something_wrong)
            }
        }

        logInClickListener()
        switchPasswordVisibilityListener()
    }

    private fun logInClickListener() {
        with(binding) {
            btnLogin.setOnClickListener {
                if (etFirstName.text.isNullOrBlank()) {
                    showToast(R.string.name_cannot_empty)
                } else {
                    viewModel.checkUserExists(etFirstName.text.toString().trim())
                }
            }
        }
    }

    private fun switchPasswordVisibilityListener() {
        with(binding) {
            ivPasswordVisibilitySwitcher.setOnClickListener {
                if (isPasswordHide) {
                    etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                    isPasswordHide = false
                } else {
                    etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                    isPasswordHide = true
                }
            }
        }
    }

    companion object{
        const val RESULT_USER_NAME_KEY = "result_user_name"
        const val BUNDLE_USER_NAME_KEY = "bundle_user_name"
    }
}