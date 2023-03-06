package com.example.onlineshop.modules.home.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.onlineshop.modules.home.presentation.delegates.*
import com.example.onlineshop.modules.home.presentation.entities.DisplayableItem
import com.example.onlineshop.modules.home.presentation.entities.FlashSaleProductUi
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

open class HomeAdapter(
    private val iNavigateToProductDetails: INavigateToProductDetails
) : AsyncListDifferDelegationAdapter<DisplayableItem>(DisplayableItemDiffCallback()) {

    companion object {
        const val VIEW_TYPE_CATEGORIES = 0
        const val VIEW_TYPE_LATEST_PRODUCTS = 1
        const val VIEW_TYPE_FLASH_SALE_PRODUCTS = 2
        const val VIEW_TYPE_BRANDS = 3
    }

    init {
        delegatesManager
            .addDelegate(VIEW_TYPE_CATEGORIES, categoriesDelegate())
            .addDelegate(VIEW_TYPE_LATEST_PRODUCTS, latestProductsDelegate())
            .addDelegate(
                VIEW_TYPE_FLASH_SALE_PRODUCTS,
                flashSaleProductsDelegate(iNavigateToProductDetails)
            )
            .addDelegate(VIEW_TYPE_BRANDS, brandDelegate())
    }

}

class DisplayableItemDiffCallback : DiffUtil.ItemCallback<DisplayableItem>() {

    override fun areItemsTheSame(
        oldItem: DisplayableItem,
        newItem: DisplayableItem
    ): Boolean {
        return oldItem.getItemId() == newItem.getItemId()
    }

    override fun areContentsTheSame(
        oldItem: DisplayableItem,
        newItem: DisplayableItem
    ): Boolean {
        return oldItem.getItemHash() == newItem.getItemHash()
    }
}