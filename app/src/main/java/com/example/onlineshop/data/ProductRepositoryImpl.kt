package com.example.onlineshop.data

import com.example.onlineshop.core.data.network.ShopApi
import com.example.onlineshop.core.domain.entity.*
import com.example.onlineshop.domain.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val shopApi: ShopApi
): ProductRepository {
    override suspend fun getLatestProduct(): List<LatestProduct> {
        val res = shopApi.getLatestSeenProducts()
        return res.latest.map { it.toLatestProduct() }
    }

    override suspend fun getFlashSaleProduct(): List<FlashSaleProduct> {
        val res = shopApi.getSaleProducts()
        return res.flashSale.map { it.toFlashSaleProduct() }
    }

    override suspend fun getProductDetails(): ProductDetails {
        val res = shopApi.getProductDetails()
        return res.toProductDetails()
    }
}