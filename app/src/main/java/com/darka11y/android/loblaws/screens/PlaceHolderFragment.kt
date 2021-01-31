package com.darka11y.android.loblaws.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.darka11y.android.loblaws.R
import com.darka11y.android.loblaws.databinding.PlaceHolderFragmentBinding

class PlaceHolderFragment : Fragment() {
    private lateinit var binding: PlaceHolderFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        // Create Binding and Inflate layout
        binding = DataBindingUtil.inflate(inflater, R.layout.place_holder_fragment, container, false)

        return binding.root

    }
}