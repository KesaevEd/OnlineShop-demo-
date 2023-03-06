package com.example.onlineshop.modules.home.presentation.delegates

import com.bumptech.glide.Glide
import com.example.onlineshop.databinding.ItemBrandsBinding
import com.example.onlineshop.databinding.ItemCategoryBinding
import com.example.onlineshop.modules.home.presentation.entities.BrandUi
import com.example.onlineshop.modules.home.presentation.entities.CategoryUi
import com.example.onlineshop.modules.home.presentation.entities.DisplayableItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun brandDelegate() =
    adapterDelegateViewBinding<BrandUi, DisplayableItem, ItemBrandsBinding>({ layoutInflater, root ->
        ItemBrandsBinding.inflate(layoutInflater, root, false)
    }) {
        bind {
            with(binding) {
                clContainer.setBackgroundResource(item.backGround)
            }
        }
    }