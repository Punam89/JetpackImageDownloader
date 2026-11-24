package com.example.jetpackapplication

import retrofit2.http.GET
import retrofit2.http.Query

/*  Defines REST API endpoints. */
interface ApiService {

    // Suspend function because network calls should run inside coroutines.
    @GET("api/") // Makes a GET request.
    suspend fun getImages(
        @Query("key") apiKey: String
    ): PixabayResponse

}