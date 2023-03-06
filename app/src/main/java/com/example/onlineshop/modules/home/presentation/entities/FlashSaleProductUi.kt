package com.example.onlineshop.modules.home.presentation.entities

data class FlashSaleProductUi(
    var category: String? = null,
    var name: String? = null,
    var price: Double? = null,
    var discount: Int? = null,
    var imageUrl: String? = null
) : DisplayableItem{
    override fun getItemId(): Long = Long.MIN_VALUE

    override fun getItemHash(): Int = hashCode()
}

data class FlashSaleProductsUi(
    val flashSaleProducts: List<DisplayableItem>
): DisplayableItem {
    override fun getItemId(): Long = Long.MIN_VALUE

    override fun getItemHash(): Int {
        var hash = 0
        flashSaleProducts.forEach { lesson ->
            hash += lesson.getItemHash()
        }
        return hash
    }
}