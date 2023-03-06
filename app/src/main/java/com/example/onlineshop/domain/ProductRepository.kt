package com.example.onlineshop.domain

import com.example.onlineshop.core.domain.entity.FlashSaleProduct
import com.example.onlineshop.core.domain.entity.LatestProduct
import com.example.onlineshop.core.domain.entity.ProductDetails

interface ProductRepository {

    suspend fun getLatestProduct(): List<LatestProduct>

    suspend fun getFlashSaleProduct(): List<FlashSaleProduct>

    suspend fun getProductDetails(): ProductDetails

}