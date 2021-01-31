package com.darka11y.android.loblaws.screens.productdetails

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.darka11y.android.loblaws.network.Entry

class ProductDetailsViewModel(productDetails: Entry, application: Application) : ViewModel() {

    private val _selectedProduct = MutableLiveData<Entry>()
    val selectedProduct: LiveData<Entry> get() = _selectedProduct

    init {
        Log.i("ProductDetailsViewModel", "Product Details View Model Created!")
        _selectedProduct.value = productDetails
    }
}