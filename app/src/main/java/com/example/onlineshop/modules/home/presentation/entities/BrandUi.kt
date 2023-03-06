package com.example.onlineshop.modules.home.presentation.entities

data class BrandUi(
    val backGround: Int
): DisplayableItem{
    override fun getItemId(): Long = Long.MIN_VALUE

    override fun getItemHash(): Int = hashCode()
}
