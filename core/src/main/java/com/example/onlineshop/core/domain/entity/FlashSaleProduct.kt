package com.example.onlineshop.core.domain.entity

import com.example.onlineshop.core.data.network.response.FlashSaleNetworkEntity

data class FlashSaleProduct(
    var category: String? = null,
    var name: String? = null,
    var price: Double? = null,
    var discount: Int? = null,
    var imageUrl: String? = null
)

fun FlashSaleNetworkEntity.toFlashSaleProduct(): FlashSaleProduct {
    return FlashSaleProduct(
        category = category,
        name = name,
        price = price,
        discount = discount,
        imageUrl = imageUrl
    )
}