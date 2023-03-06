package com.example.onlineshop.modules.home.presentation.delegates

import android.annotation.SuppressLint
import com.bumptech.glide.Glide
import com.example.onlineshop.databinding.ItemFlashSaleBinding
import com.example.onlineshop.databinding.ItemFlashSaleProductsBinding
import com.example.onlineshop.databinding.ItemLatestProductsBinding
import com.example.onlineshop.modules.home.presentation.adapters.FlashSaleAdapter
import com.example.onlineshop.modules.home.presentation.adapters.INavigateToProductDetails
import com.example.onlineshop.modules.home.presentation.adapters.LatestAdapter
import com.example.onlineshop.modules.home.presentation.entities.DisplayableItem
import com.example.onlineshop.modules.home.presentation.entities.FlashSaleProductUi
import com.example.onlineshop.modules.home.presentation.entities.FlashSaleProductsUi
import com.example.onlineshop.modules.home.presentation.entities.LatestProductsUi
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

@SuppressLint("SetTextI18n")
fun flashSaleProductDelegate(iNavigateToProductDetails: INavigateToProductDetails) =
    adapterDelegateViewBinding<FlashSaleProductUi, DisplayableItem, ItemFlashSaleBinding>({ layoutInflater, root ->
        ItemFlashSaleBinding.inflate(layoutInflater, root, false)
    }) {
        binding.root.setOnClickListener{ iNavigateToProductDetails.navigateToDetailsScreen() }
        bind {
            with(binding) {
                tvName.text = item.name
                tvCategory.text = item.category
                tvPrice.text = item.price.toString()
                tvDiscount.text = item.discount.toString() + "% off"
                Glide.with(ivBackground)
                    .load(item.imageUrl)
                    .into(ivBackground)
            }
        }
    }

fun flashSaleProductsDelegate(iNavigateToProductDetails: INavigateToProductDetails) =
    adapterDelegateViewBinding<FlashSaleProductsUi, DisplayableItem, ItemFlashSaleProductsBinding>(
        { layoutInflater, root ->
            ItemFlashSaleProductsBinding.inflate(layoutInflater, root, false)
        }
    ) {
        val adapter = FlashSaleAdapter(iNavigateToProductDetails)
        bind {
            binding.rvFlashSale.adapter = adapter
            adapter.items = item.flashSaleProducts
            binding.rvFlashSale.scrollToPosition(0)
        }
    }