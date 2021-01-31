package com.darka11y.android.loblaws.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ProductData (
    var entries: List<Entry>? = null
) : Parcelable

@Parcelize
class Entry : Parcelable {
    var code: String? = null
    var image: String? = null
    var name: String? = null
    var price: String? = null
    var type: String? = null
}
