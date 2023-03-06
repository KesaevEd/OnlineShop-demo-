package com.example.onlineshop.modules.home.presentation.adapters

import com.example.onlineshop.modules.home.presentation.delegates.latestProductDelegate
import com.example.onlineshop.modules.home.presentation.entities.DisplayableItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class LatestAdapter: AsyncListDifferDelegationAdapter<DisplayableItem>(
    DisplayableItemDiffCallback()
) {
    companion object{
        const val VIEW_TYPE_CATEGORY = 1
    }

    init {
        delegatesManager
            .addDelegate(VIEW_TYPE_CATEGORY, latestProductDelegate())
    }
}