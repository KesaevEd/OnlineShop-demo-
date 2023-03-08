package com.example.onlineshop.modules.home.presentation.adapters

import com.example.onlineshop.modules.home.presentation.delegates.brandDelegate
import com.example.onlineshop.modules.home.presentation.entities.DisplayableItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class BrandAdapter: AsyncListDifferDelegationAdapter<DisplayableItem>(
    DisplayableItemDiffCallback()
) {
    companion object{
        const val VIEW_TYPE_CATEGORY = 0
    }

    init {
        delegatesManager
            .addDelegate(VIEW_TYPE_CATEGORY, brandDelegate())
    }
}