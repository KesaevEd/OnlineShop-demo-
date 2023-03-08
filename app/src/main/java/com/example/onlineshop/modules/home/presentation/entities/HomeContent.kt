package com.example.onlineshop.modules.home.presentation.entities

import com.example.onlineshop.core.domain.entity.Brand
import com.example.onlineshop.core.domain.entity.Category
import com.example.onlineshop.core.domain.entity.FlashSaleProduct
import com.example.onlineshop.core.domain.entity.LatestProduct

data class HomeContent(
    val categories: List<Category> = emptyList(),
    val latestProducts: List<LatestProduct> = emptyList(),
    val flashSaleProducts: List<FlashSaleProduct> = emptyList(),
    val brands: List<Brand> = emptyList()
)
