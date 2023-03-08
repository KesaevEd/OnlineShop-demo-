package com.example.onlineshop.modules.productdetails.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.onlineshop.App
import com.example.onlineshop.R
import com.example.onlineshop.base.lazyViewModel
import com.example.onlineshop.databinding.FragmentProductDetailsBinding
import com.example.onlineshop.modules.home.di.DaggerHomeComponent
import com.example.onlineshop.modules.productdetails.adapters.ColorAdapter
import com.example.onlineshop.modules.productdetails.adapters.IChoosePhoto
import com.example.onlineshop.modules.productdetails.adapters.ImageAdapter
import java.math.MathContext

class ProductDetailsFragment : Fragment(R.layout.fragment_product_details), IChoosePhoto {

    private val binding by viewBinding(FragmentProductDetailsBinding::bind)

    private val component = DaggerHomeComponent.builder().appComponent(App.component).build()

    private val viewModel by lazyViewModel { component.productDetailsViewModel().create() }

    private val colorAdapter by lazy { ColorAdapter() }
    private val imageAdapter by lazy { ImageAdapter(this) }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            initRecyclerViews()
            setOnClickListeners()

            viewModel.getProductDetails()

            viewModel.detailsLiveData.observe(viewLifecycleOwner) { details ->

                details.imageUrls?.let {
                    Glide.with(ivMainImage)
                        .load(it[0])
                        .into(ivMainImage)

                    imageAdapter.data = it
                }
                details.name?.let {
                    tvName.text = it
                }

                details.price?.let {
                    tvPrice.text = "$ ${"%.2f".format(it.toDouble())}"
                }

                details.description?.let {
                    tvDescription.text = it
                }

                details.rating?.let {
                    tvRating.text = it.toString()
                }

                details.numberOfReviews?.let {
                    tvReviewsCount.text = "($it reviews)"
                }

                details.colors?.let{
                    colorAdapter.data = it
                }

            }
        }

    }

    private fun setOnClickListeners(){
        binding.ivArrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun initRecyclerViews(){
        binding.rvPhotos.adapter = imageAdapter
        binding.rvColors.adapter = colorAdapter
    }

    override fun choosePhoto(imageUrl:String) {
        Glide.with(binding.ivMainImage)
            .load(imageUrl)
            .into(binding.ivMainImage)
    }

}