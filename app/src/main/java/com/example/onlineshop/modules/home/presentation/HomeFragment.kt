package com.example.onlineshop.modules.home.presentation

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.onlineshop.App
import com.example.onlineshop.R
import com.example.onlineshop.base.lazyViewModel
import com.example.onlineshop.databinding.FragmentHomeBinding
import com.example.onlineshop.modules.home.di.DaggerHomeComponent
import com.example.onlineshop.modules.home.presentation.adapters.HomeAdapter
import com.example.onlineshop.modules.home.presentation.adapters.INavigateToProductDetails

class HomeFragment : Fragment(R.layout.fragment_home), INavigateToProductDetails {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val component = DaggerHomeComponent.builder().appComponent(App.component).build()
    private val homeViewModel by lazyViewModel { component.homeViewModel().create() }

    private val homeAdapter: HomeAdapter by lazy { HomeAdapter(this) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerViews()
        initSpinnerLocation()

        homeViewModel.getHomeContent()

        homeViewModel.homeContentLiveData.observe(viewLifecycleOwner) {
            homeAdapter.items = it
        }

        homeViewModel.setUserAvatarByUserName()

        homeViewModel.userAvatarLiveData.observe(viewLifecycleOwner){
            Glide.with(binding.ivAvatar).load(it).into(binding.ivAvatar)
        }
    }

    private fun initRecyclerViews() {
        binding.rvRoot.adapter = homeAdapter
    }

    private fun initSpinnerLocation() {
        val countries = listOf("Location")
        val adapter: ArrayAdapter<CharSequence> =
            ArrayAdapter(requireContext(), R.layout.item_spinner, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerLocation.adapter = adapter
    }

    override fun navigateToDetailsScreen() {
        findNavController().navigate(R.id.action_homeFragment_to_productDetailsFragment)
    }
}