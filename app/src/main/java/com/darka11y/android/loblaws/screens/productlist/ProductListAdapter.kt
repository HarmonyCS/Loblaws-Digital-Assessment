package com.darka11y.android.loblaws.screens.productlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.darka11y.android.loblaws.R
import com.darka11y.android.loblaws.network.Entry

class ProductListAdapter (private val onClickListener: OnClickListener) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {
    var data = listOf<Entry>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    // Size of the product list
    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data.elementAt(position)
        holder.productName.text = item.name
        holder.productPrice.text = item.price

        Glide.with(holder.itemView.context).load(item.image)
            .into(holder.productImage)

        holder.productContainer.setOnClickListener {
            onClickListener.onClick( item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.product_item_view, parent,false)

        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.product_image_list_item)
        val productName: TextView = itemView.findViewById(R.id.product_name_list_item)
        val productPrice: TextView = itemView.findViewById(R.id.product_price_list_item)
        val productContainer: ConstraintLayout = itemView.findViewById(R.id.product_item_container)
    }

    class OnClickListener(val clickListener: (productItem: Entry) -> Unit) {
        fun onClick(productItem:Entry) = clickListener(productItem)
    }

}