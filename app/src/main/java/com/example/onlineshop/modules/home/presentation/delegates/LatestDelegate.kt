package com.example.onlineshop.modules.home.presentation.delegates

import com.bumptech.glide.Glide
import com.example.onlineshop.databinding.ItemCategoriesBinding
import com.example.onlineshop.databinding.ItemLatestProductBinding
import com.example.onlineshop.databinding.ItemLatestProductsBinding
import com.example.onlineshop.modules.home.presentation.adapters.CategoryAdapter
import com.example.onlineshop.modules.home.presentation.adapters.LatestAdapter
import com.example.onlineshop.modules.home.presentation.entities.DisplayableItem
import com.example.onlineshop.modules.home.presentation.entities.LatestProductUi
import com.example.onlineshop.modules.home.presentation.entities.LatestProductsUi
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun latestProductDelegate() =
    adapterDelegateViewBinding<LatestProductUi, DisplayableItem, ItemLatestProductBinding>({ layoutInflater, root ->
        ItemLatestProductBinding.inflate(layoutInflater, root, false)
    }) {
        bind {
            with(binding) {
                tvName.text = item.name
                tvCategory.text = item.category
                tvPrice.text = item.price.toString()
                Glide.with(ivIcon)
                    .load(item.imageUrl)
                    .into(ivIcon)
            }
        }
    }

fun latestProductsDelegate() =
    adapterDelegateViewBinding<LatestProductsUi, DisplayableItem, ItemLatestProductsBinding>(
        { layoutInflater, root ->
            ItemLatestProductsBinding.inflate(layoutInflater, root, false)
        }
    ) {
        val adapter = LatestAdapter()
        bind {
            binding.rvLatest.adapter = adapter
            adapter.items = item.latestProducts
            binding.rvLatest.scrollToPosition(0)
        }
    }