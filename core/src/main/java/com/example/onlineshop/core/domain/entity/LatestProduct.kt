package com.example.onlineshop.core.domain.entity

import com.example.onlineshop.core.data.network.response.LatestNetworkEntity

data class LatestProduct(
    var category: String? = null,
    var name: String? = null,
    var price: Double? = null,
    var imageUrl: String? = null
)

fun LatestNetworkEntity.toLatestProduct(): LatestProduct{
    return LatestProduct(
        category = category,
        name = name,
        price = price,
        imageUrl = imageUrl
    )
}