package com.example.onlineshop.core.data.network.response

import com.google.gson.annotations.SerializedName

data class LatestSeenProductsNetworkEntity(
    @SerializedName("latest") var latest: ArrayList<LatestNetworkEntity> = arrayListOf()
)

data class LatestNetworkEntity(
    @SerializedName("category") var category: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("price") var price: Double? = null,
    @SerializedName("image_url") var imageUrl: String? = null
)