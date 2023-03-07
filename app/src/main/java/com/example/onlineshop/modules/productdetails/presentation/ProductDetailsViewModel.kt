package com.example.onlineshop.modules.productdetails.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.core.domain.entity.ProductDetails
import com.example.onlineshop.domain.ProductRepository
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class ProductDetailsViewModel @AssistedInject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val details = MutableLiveData<ProductDetails>()
    val detailsLiveData: LiveData<ProductDetails> = details

    fun getProductDetails(){
        viewModelScope.launch {
            val response = productRepository.getProductDetails()
            details.value = response
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(): ProductDetailsViewModel
    }
}