package com.example.onlineshop.modules.home.presentation.adapters

import com.example.onlineshop.modules.home.presentation.delegates.flashSaleProductDelegate
import com.example.onlineshop.modules.home.presentation.entities.DisplayableItem
import com.example.onlineshop.modules.home.presentation.entities.FlashSaleProductUi
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class FlashSaleAdapter(iNavigateToProductDetails: INavigateToProductDetails): AsyncListDifferDelegationAdapter<DisplayableItem>(
    DisplayableItemDiffCallback()
) {
    companion object{
        const val VIEW_TYPE_CATEGORY = 2
    }

    init {
        delegatesManager
            .addDelegate(VIEW_TYPE_CATEGORY, flashSaleProductDelegate(iNavigateToProductDetails))
    }
}