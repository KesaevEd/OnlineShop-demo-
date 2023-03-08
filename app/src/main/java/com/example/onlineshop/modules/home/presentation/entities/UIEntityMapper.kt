package com.example.onlineshop.modules.home.presentation.entities

import com.example.onlineshop.core.domain.entity.Brand
import com.example.onlineshop.core.domain.entity.Category
import com.example.onlineshop.core.domain.entity.FlashSaleProduct
import com.example.onlineshop.core.domain.entity.LatestProduct

fun HomeContent.toUiEntity(): List<DisplayableItem> {
    val result = mutableListOf<DisplayableItem>()

    val categoriesUi = categories.toCategoriesUiEntity()
    val latestUiEntities = latestProducts.toLatestUiEntity()
    val flashSaleUiEntities = flashSaleProducts.toFlashSaleUiEntity()
    val brandUiEntities = brands.toBrandsUiEntity()

    result.add(CategoriesUi(categoriesUi))
    result.add(LatestProductsUi(latestUiEntities))
    result.add(FlashSaleProductsUi(flashSaleUiEntities))
    result.add(BrandsUi(brandUiEntities))

    return result
}

fun List<Category>.toCategoriesUiEntity(): List<DisplayableItem> {
    return map { it.toCategoryUiEntity() }
}

fun Category.toCategoryUiEntity(): CategoryUi {
    return CategoryUi(
        iconUri = iconUri,
        name = name
    )
}

fun List<LatestProduct>.toLatestUiEntity(): List<DisplayableItem> {
    return map { it.toUiEntity() }
}

fun LatestProduct.toUiEntity(): LatestProductUi {
    return LatestProductUi(
        name = name,
        category = category,
        price = price,
        imageUrl = imageUrl
    )
}

fun List<FlashSaleProduct>.toFlashSaleUiEntity(): List<DisplayableItem> {
    return map { it.toUiEntity() }
}

fun FlashSaleProduct.toUiEntity(): FlashSaleProductUi {
    return FlashSaleProductUi(
        name = name,
        category = category,
        price = price,
        imageUrl = imageUrl,
        discount = discount
    )
}

fun List<Brand>.toBrandsUiEntity(): List<DisplayableItem> {
    return map { it.toBrandUiEntity() }
}

fun Brand.toBrandUiEntity(): BrandUi {
    return BrandUi(
        backGround = backGround
    )
}