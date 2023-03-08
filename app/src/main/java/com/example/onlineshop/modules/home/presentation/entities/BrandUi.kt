package com.example.onlineshop.modules.home.presentation.entities

data class BrandUi(
    val backGround: Int
): DisplayableItem{
    override fun getItemId(): Long = Long.MIN_VALUE

    override fun getItemHash(): Int = hashCode()
}

data class BrandsUi(
    val brands: List<DisplayableItem>
) : DisplayableItem {
    override fun getItemId(): Long = Long.MIN_VALUE

    override fun getItemHash(): Int {
        var hash = -1
        brands.forEach { brands ->
            hash += brands.getItemHash()
        }
        return hash
    }
}
