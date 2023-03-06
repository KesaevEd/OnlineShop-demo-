package com.example.onlineshop.modules.home.presentation.entities

data class CategoryUi(
    val iconUri: Int? = null,
    val name: String? = null
) : DisplayableItem{
    override fun getItemId(): Long = Long.MIN_VALUE

    override fun getItemHash(): Int = hashCode()
}

data class CategoriesUi(
    val categories: List<DisplayableItem>
) : DisplayableItem {
    override fun getItemId(): Long = Long.MIN_VALUE

    override fun getItemHash(): Int {
        var hash = -1
        categories.forEach { categories ->
            hash += categories.getItemHash()
        }
        return hash
    }
}