package com.example.onlineshop.core.data.network.response

import com.google.gson.annotations.SerializedName

data class SaleProductsNetworkEntity(
    @SerializedName("flash_sale") var flashSale: ArrayList<FlashSale> = arrayListOf()
)

data class FlashSale(
    @SerializedName("category") var category: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("price") var price: Double? = null,
    @SerializedName("discount") var discount: Int? = null,
    @SerializedName("image_url") var imageUrl: String? = null
)