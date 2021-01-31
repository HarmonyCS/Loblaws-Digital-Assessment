package com.darka11y.android.loblaws.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://gist.githubusercontent.com/r2vq/2ac197145db3f6cdf1a353feb744cf8e/raw/b1e722f608b00ddde138a0eef2261c6ffc8b08d7/"

// Setup Retrofit
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

// Interface for HTTP Request using Coroutines
interface ProductApiService {
    @GET("cart.json")
    suspend fun getProducts(): ProductData
}

// Lazy Load Retrofit
object ProductAPI {
    val retrofitService : ProductApiService by lazy {
        retrofit.create(ProductApiService::class.java)
    }
}
