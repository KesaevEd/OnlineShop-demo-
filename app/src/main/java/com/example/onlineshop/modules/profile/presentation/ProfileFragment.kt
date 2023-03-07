package com.example.onlineshop.modules.profile.presentation

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.onlineshop.App
import com.example.onlineshop.R
import com.example.onlineshop.base.lazyViewModel
import com.example.onlineshop.databinding.FragmentProfileBinding
import com.example.onlineshop.modules.auth.di.DaggerAuthComponent
import com.example.onlineshop.modules.auth.login.presentation.LogInFragment
import com.example.onlineshop.modules.profile.di.DaggerProfileComponent


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val binding by viewBinding(FragmentProfileBinding::bind)

    private val component = DaggerProfileComponent.builder().appComponent(App.component).build()

    private val profileViewModel by lazyViewModel { component.profileViewModel().create() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {

            profileViewModel.setNewUserByName()

            profileViewModel.userLiveData.observe(viewLifecycleOwner) { user ->
                user.name?.let {
                    tvUserName.text = it
                }

                user.imageUri?.let {
                    Glide.with(binding.ivAvatar).load(it).into(binding.ivAvatar)
                }
            }
        }

        setOnMenuItemsClickListeners()
        setOnLogoutClickListener()
        changePhotoClickListener()
    }

    private fun setOnMenuItemsClickListeners() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setOnLogoutClickListener(){
        binding.flLogout.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun changePhotoClickListener() {
        binding.btnUpload.setOnClickListener {
            changePhoto()
        }
        binding.tvChangePhoto.setOnClickListener {
            changePhoto()
        }
    }

    private fun changePhoto() {
        val i = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        );
        startActivityForResult(i, RESULT_LOAD_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_LOAD_IMAGE && null != data) {
            val selectedImage = data.data
            profileViewModel.setNewUserAvatar(selectedImage)
        }
    }

    companion object {
        private const val RESULT_LOAD_IMAGE = 100
    }
}