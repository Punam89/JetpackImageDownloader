package com.example.jetpackapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*   Creates a single Retrofit instance throughout the app.  */


object RetrofitInstance {

    private const val BASE_URL = "https://pixabay.com/"

    private val retrofit by lazy {
        // Creates Retrofit builder.
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())     // Converts JSON into Kotlin objects
            .build()
    }


    /* Lazy initialization Object created only when first used.*/
    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)     // Creates API implementation.
    }
}

