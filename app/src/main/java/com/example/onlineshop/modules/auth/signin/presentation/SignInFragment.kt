package com.example.onlineshop.modules.auth.signin.presentation

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.onlineshop.App
import com.example.onlineshop.R
import com.example.onlineshop.base.lazyViewModel
import com.example.onlineshop.base.showToast
import com.example.onlineshop.databinding.FragmentSignInBinding
import com.example.onlineshop.modules.auth.di.DaggerAuthComponent

class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    private val binding by viewBinding(FragmentSignInBinding::bind)

    private val component = DaggerAuthComponent.builder().appComponent(App.component).build()

    private val viewModel by lazyViewModel { component.signInViewModel().create() }

    private val userViewModel by lazyViewModel { component.profileViewModel().create() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            viewModel.setNewUser()
            viewModel.userLiveData.observe(viewLifecycleOwner) { user ->
                user.name?.let {
                    etFirstName.text = Editable.Factory.getInstance().newEditable(it)
                }
                user.lastname?.let {
                    etSecondName.text = Editable.Factory.getInstance().newEditable(it)
                }
                user.email?.let {
                    etEmail.text = Editable.Factory.getInstance().newEditable(it)
                }
            }

            viewModel.isUserSavedLiveData.observe(viewLifecycleOwner) { isSaved ->
                try {
                    if (isSaved) {
                        viewModel.saveUserName(etFirstName.text.toString().trim())
                        findNavController().navigate(R.id.action_signInFragment_to_home)
                    } else {
                        showToast(R.string.username_exists)
                    }
                } catch (e: java.lang.Exception) {
                    showToast(R.string.something_wrong)
                }
            }

            btnLogInClickListener()
            btnSignInClickListener()
            setOnSaveNameListeners()
            setOnSaveLastNameListeners()
            setOnSaveEmailListeners()
        }
    }

    private fun btnLogInClickListener() {
        binding.tvLogin.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_logInFragment)
        }
    }

    private fun btnSignInClickListener() {
        with(binding) {
            btnSignIn.setOnClickListener {
                if (!etFirstName.text.isNullOrBlank()) {
                    if(emailValidation()) {
                        viewModel.saveNewUser()
                        userViewModel.setNewUser(viewModel.userLiveData.value!!)
                    }else{
                        etEmail.setBackgroundResource(R.drawable.bg_edit_text_invalid)
                        showToast(R.string.invalid_email)
                    }
                } else {
                    etFirstName.setBackgroundResource(R.drawable.bg_edit_text_invalid)
                    showToast(R.string.name_cannot_empty)
                }
            }
        }

    }

    private fun setOnSaveNameListeners() {
        binding.etFirstName.setOnFocusChangeListener { v, hasFocus ->
            val et = v as EditText
            if (!hasFocus) {
                viewModel.setNewUserData(name = et.text.toString().trim())
            }else{
                binding.etFirstName.setBackgroundResource(R.drawable.bg_edit_text_signin)
            }
        }
    }

    private fun setOnSaveLastNameListeners() {
        binding.etSecondName.setOnFocusChangeListener { v, hasFocus ->
            val et = v as EditText
            if (!hasFocus) {
                viewModel.setNewUserData(lastName = et.text.toString().trim())
            }
        }
    }

    private fun setOnSaveEmailListeners() {
        binding.etEmail.setOnFocusChangeListener { v, hasFocus ->
            val et = v as EditText
            if (!hasFocus) {
                viewModel.setNewUserData(email = et.text.toString().trim())
            }else{
                binding.etEmail.setBackgroundResource(R.drawable.bg_edit_text_signin)
            }
        }
    }

    private fun emailValidation(): Boolean{
        val dot = "."
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+$dot+[a-z]+"
        return binding.etEmail.text.toString().trim { it <= ' ' }.matches(emailPattern.toRegex())
    }
}