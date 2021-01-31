package com.darka11y.android.loblaws.screens.productdetails

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.darka11y.android.loblaws.network.Entry

class ProductDetailsViewModelFactory(
    private val productDetails: Entry,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductDetailsViewModel::class.java)) {
            return ProductDetailsViewModel(productDetails, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
