package com.example.onlineshop.modules.home.presentation.delegates

import com.example.onlineshop.R
import com.example.onlineshop.databinding.ItemBrandBinding
import com.example.onlineshop.databinding.ItemsBrandsBinding
import com.example.onlineshop.modules.home.presentation.adapters.BrandAdapter
import com.example.onlineshop.modules.home.presentation.entities.BrandUi
import com.example.onlineshop.modules.home.presentation.entities.BrandsUi
import com.example.onlineshop.modules.home.presentation.entities.DisplayableItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun brandsDelegate() =
    adapterDelegateViewBinding<BrandsUi, DisplayableItem, ItemsBrandsBinding>(
        { layoutInflater, root ->
            ItemsBrandsBinding.inflate(layoutInflater, root, false)
        }
    ) {
        val adapter = BrandAdapter()
        bind {
            binding.rvBrands.adapter = adapter
            adapter.items = item.brands
        }
    }
fun brandDelegate() =
    adapterDelegateViewBinding<BrandUi, DisplayableItem, ItemBrandBinding>({ layoutInflater, root ->
        ItemBrandBinding.inflate(layoutInflater, root, false)
    }) {
        bind {
            with(binding) {
                clContainer.setCardBackgroundColor(getColor(item.backGround))
            }
        }
    }