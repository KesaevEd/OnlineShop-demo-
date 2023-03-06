package com.example.onlineshop.modules.home.presentation


import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.onlineshop.R
import com.example.onlineshop.core.data.storage.database.UserSharedPref
import com.example.onlineshop.core.domain.entity.Category
import com.example.onlineshop.core.domain.entity.FlashSaleProduct
import com.example.onlineshop.core.domain.entity.LatestProduct
import com.example.onlineshop.core.domain.entity.User
import com.example.onlineshop.domain.ProductRepository
import com.example.onlineshop.domain.UserRepository
import com.example.onlineshop.modules.home.presentation.entities.DisplayableItem
import com.example.onlineshop.modules.home.presentation.entities.FlashSaleProductsUi
import com.example.onlineshop.modules.home.presentation.entities.HomeContent
import com.example.onlineshop.modules.home.presentation.entities.toUiEntity
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class HomeViewModel @AssistedInject constructor(
    private val productRepository: ProductRepository,
    private val userRepository: UserRepository,
    private val userSharedPref: UserSharedPref
) : ViewModel() {


    private val homeContent = MutableLiveData<List<DisplayableItem>>()
    val homeContentLiveData: LiveData<List<DisplayableItem>> = homeContent

    private val userAvatar = MutableLiveData<Uri>()
    val userAvatarLiveData: LiveData<Uri> = userAvatar
    fun getHomeContent() {
        viewModelScope.launch {
            val latest = productRepository.getLatestProduct()
            val flashSale = productRepository.getFlashSaleProduct()

            val content = HomeContent(
                categories = getCategories(),
                latestProducts = latest,
                flashSaleProducts = flashSale
            )

            val contentUi = content.toUiEntity()
            homeContent.value = contentUi
        }
    }

    private fun getCategories(): List<Category>{
        val categories = mutableListOf<Category>()
        val names = listOf(R.string.phones, R.string.headphones, R.string.games, R.string.cars, R.string.furniture, R.string.kids)
        val icons = listOf(R.drawable.ic_phone, R.drawable.ic_headphones, R.drawable.ic_games, R.drawable.ic_car, R.drawable.ic_furniture, R.drawable.ic_kids)
        for(i in names.indices){
            val category = Category(name = names[i].toString(), iconUri = icons[i] )
            categories.add(category)
        }

        return categories
    }

    fun setUserAvatarByUserName(){
        viewModelScope.launch {
            val name = userSharedPref.userName
            val newUser = userRepository.getUserByName(name)
            newUser.imageUri?.let {
                userAvatar.value = it
            }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(): HomeViewModel
    }
}