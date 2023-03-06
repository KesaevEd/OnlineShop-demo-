package com.example.onlineshop.modules.home.presentation.delegates

import com.example.onlineshop.databinding.ItemCategoriesBinding
import com.example.onlineshop.databinding.ItemCategoryBinding
import com.example.onlineshop.modules.home.presentation.adapters.CategoryAdapter
import com.example.onlineshop.modules.home.presentation.entities.CategoriesUi
import com.example.onlineshop.modules.home.presentation.entities.CategoryUi
import com.example.onlineshop.modules.home.presentation.entities.DisplayableItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun categoriesDelegate() =
    adapterDelegateViewBinding<CategoriesUi, DisplayableItem, ItemCategoriesBinding>(
        { layoutInflater, root ->
            ItemCategoriesBinding.inflate(layoutInflater, root, false)
        }
    ) {
        val adapter = CategoryAdapter()
        bind {
            binding.rvCategory.adapter = adapter
            adapter.items = item.categories
        }
    }

fun categoryDelegate() =
    adapterDelegateViewBinding<CategoryUi, DisplayableItem, ItemCategoryBinding>({ layoutInflater, root ->
        ItemCategoryBinding.inflate(layoutInflater, root, false)
    }) {
        bind {
            with(binding) {
                tvName.text = getString(item.name!!.toInt())
                item.iconUri?.let {
                    ivIcon.setImageDrawable(getDrawable(item.iconUri!!))
                }
            }
        }
    }