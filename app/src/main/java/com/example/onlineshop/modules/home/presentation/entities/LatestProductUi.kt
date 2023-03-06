package com.example.onlineshop.modules.home.presentation.entities

data class LatestProductUi(
    var category: String? = null,
    var name: String? = null,
    var price: Double? = null,
    var imageUrl: String? = null
) : DisplayableItem{
    override fun getItemId(): Long = Long.MIN_VALUE

    override fun getItemHash(): Int = hashCode()
}


data class LatestProductsUi(
    val latestProducts:List<DisplayableItem>
): DisplayableItem{
    override fun getItemId(): Long = Long.MIN_VALUE

    override fun getItemHash(): Int {
        var hash = 0
        latestProducts.forEach { lesson ->
            hash += lesson.getItemHash()
        }
        return hash
    }
}