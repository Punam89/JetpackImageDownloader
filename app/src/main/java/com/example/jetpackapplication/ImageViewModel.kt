package com.example.jetpackapplication

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/*
    Handles business logic and data fetching.
*/


class ImageViewModel : ViewModel() {

    companion object {
        private const val API_KEY =
            "20556304-1e1a5855144c40a60866da061"

    }

    var imageList by mutableStateOf<List<ImageItem>>(emptyList())
        private set

    init {
        fetchImages()
    }

    private fun fetchImages() {

        viewModelScope.launch {

            try {

                val response =
                    RetrofitInstance.api.getImages(API_KEY)

                imageList = response.hits

            } catch (e: Exception) {

                Log.e(
                    "API_ERROR",
                    e.message ?: "Unknown Error"
                )
            }
        }
    }
}



