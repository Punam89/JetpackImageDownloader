package com.example.jetpackapplication

import com.google.gson.annotations.SerializedName


/* Represents a single image object received from the API. */
/*data class ImageItem(
    val id: Int,                //  Unique image identifier.
    val imageUrl: String       // Stores image URL.
)*/

data class PixabayResponse(
    val hits: List<ImageItem>
)

data class ImageItem(
    val id: Int,

    @SerializedName("webformatURL")
    val imageUrl: String
)