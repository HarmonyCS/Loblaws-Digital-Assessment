package com.darka11y.android.loblaws.screens.productdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.darka11y.android.loblaws.databinding.ProductDetailsFragmentBinding

class ProductDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val application = requireNotNull(activity).application

        // Create the Binding and Inflate layout
        val binding = ProductDetailsFragmentBinding.inflate(inflater)

        // Specify Fragment as Lifecycle owner for LiveData updates
        binding.lifecycleOwner = viewLifecycleOwner

        // Get the SafeArgs passed from ProductListFragment using navGraph
        val productDetails = ProductDetailsFragmentArgs.fromBundle(requireArguments()).selectedProduct

        // Boilerplate constructor for ViewModel with parameters
        val viewModelFactory = ProductDetailsViewModelFactory(productDetails, application)
        binding.productDetailsViewModel = ViewModelProvider(
            this, viewModelFactory).get(ProductDetailsViewModel::class.java)

        return binding.root

    }

}