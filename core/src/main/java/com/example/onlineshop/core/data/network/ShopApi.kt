package com.example.onlineshop.core.data.network

import com.example.onlineshop.core.data.network.response.LatestSeenProductsNetworkEntity
import com.example.onlineshop.core.data.network.response.ProductDetailsNetworkEntity
import com.example.onlineshop.core.data.network.response.SaleProductsNetworkEntity
import retrofit2.http.GET

interface ShopApi {

    @GET("/v3/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatestSeenProducts(): LatestSeenProductsNetworkEntity

    @GET("/v3/a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getSaleProducts(): SaleProductsNetworkEntity

    @GET("/v3/f7f99d04-4971-45d5-92e0-70333383c239")
    suspend fun getProductDetails(): ProductDetailsNetworkEntity
}