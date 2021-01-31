package com.darka11y.android.loblaws.screens.productlist

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.darka11y.android.loblaws.R
import com.darka11y.android.loblaws.databinding.ProductListFragmentBinding

class ProductListFragment: Fragment() {
    private lateinit var binding: ProductListFragmentBinding

    // Lazy Load the ViewModel
    private val viewModel: ProductListViewModel by lazy {
        ViewModelProvider(this).get(ProductListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Create the Product List Adapter with clickListner
        val adapter = ProductListAdapter(ProductListAdapter.OnClickListener {
            viewModel.displayProductDetails(it)
        })

        // Create Binding and Inflate layout
        binding = DataBindingUtil.inflate(inflater, R.layout.product_list_fragment, container, false)

        // Set the ViewModel for DataBinding directly to XML
        binding.productListViewModel = viewModel

        // Specify Fragment as Lifecycle owner for LiveData updates
        binding.lifecycleOwner = viewLifecycleOwner

        // Set Options Menu
        setHasOptionsMenu(true)

        // Bind the adapter
        binding.productList.adapter = adapter

        viewModel.productList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        // Observe the navigateToSelectedProduct LiveData and Navigate when it isn't null
        // After navigating, call displayProductDetailsComplete() so that the ViewModel is ready for next click
        viewModel.navigateToSelectedProduct.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                // Must find the NavController from the Fragment
                this.findNavController().navigate(ProductListFragmentDirections.actionProductListFragmentToProductDetailsFragment(it))
                // Tell the ViewModel we've made the navigate call to prevent multiple navigation
                viewModel.displayProductDetailsComplete()
            }
        })

        return binding.root

    }

    //  Options Menu for Cart Placeholder
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    // Navigate to Placeholder Cart
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}