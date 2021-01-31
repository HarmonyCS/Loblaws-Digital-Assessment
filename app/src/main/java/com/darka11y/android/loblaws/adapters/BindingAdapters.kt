package com.darka11y.android.loblaws.adapters

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?){
    imageUrl?.let {
        val imageUri = imageUrl.toUri()
            .buildUpon().scheme("https")
            .build()
        // Load Image with Glide
        Glide.with(imageView.context)
            .load(imageUri)
            .into(imageView)
        //TODO .apply for .placeholder and .error images
    }
}
