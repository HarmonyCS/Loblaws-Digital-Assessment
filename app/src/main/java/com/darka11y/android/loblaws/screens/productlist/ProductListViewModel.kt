package com.darka11y.android.loblaws.screens.productlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darka11y.android.loblaws.network.Entry
import com.darka11y.android.loblaws.network.ProductAPI
import kotlinx.coroutines.launch

class ProductListViewModel : ViewModel() {

    // Product Details State with Kotlin Backer
    private val _viewProductDetails = MutableLiveData<Boolean>()
    val viewProductDetails: LiveData<Boolean> get() = _viewProductDetails

    // Response
    private val _response = MutableLiveData<String>()
    val response: LiveData<String> get() = _response

    // Product
    private val _product = MutableLiveData<Entry>()
    val product: LiveData<Entry> get() = _product

    // Products List
    private val _productList = MutableLiveData<List<Entry>>()
    val productList: LiveData<List<Entry>> get() = _productList

    // Handle Navigation
    private val _navigateToSelectedProduct = MutableLiveData<Entry>()
    val navigateToSelectedProduct: LiveData<Entry> get() = _navigateToSelectedProduct

    init {
        Log.i("ProductListViewModel", "Product List View Model Created!")
        getProducts()
    }

    /** Handling ProductDetailsView State **/

    fun displayProductDetails(productItem : Entry) {
        _navigateToSelectedProduct.value = productItem
    }

    fun displayProductDetailsComplete() {
        _navigateToSelectedProduct.value = null
    }

    /** Handle the API Calls **/
    private fun getProducts() {
        // Use Kotlin Coroutines
        viewModelScope.launch {
            try {
                _productList.value = ProductAPI.retrofitService.getProducts().entries
                _response.value = "Success: Products Retrieved!"

            } catch (e: Exception) {
                _response.value ="Failure: " + e.message
            }
        }
    }



}