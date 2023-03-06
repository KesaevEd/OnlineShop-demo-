package com.example.onlineshop.core.domain.entity

import com.example.onlineshop.core.data.network.response.ProductDetailsNetworkEntity
import com.google.gson.annotations.SerializedName

data class ProductDetails(
    var name: String? = null,
    var description: String? = null,
    var rating: Double? = null,
    var numberOfReviews: Int? = null,
    var price: Int? = null,
    var colors: ArrayList<String> = arrayListOf(),
    var imageUrls: ArrayList<String> = arrayListOf()
)

fun ProductDetailsNetworkEntity.toProductDetails(): ProductDetails{
    return ProductDetails(
        name = name,
        description = description,
        rating = rating,
        numberOfReviews = numberOfReviews,
        price = price,
        colors = colors,
        imageUrls = imageUrls
    )
}
