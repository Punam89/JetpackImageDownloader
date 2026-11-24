package com.example.jetpackapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage


/*
    Activity Starts
      ↓
setContent()
      ↓
MyApp()
      ↓
ImageGrid()
      ↓
ViewModel Created
      ↓
init{}
      ↓
fetchImages()
      ↓
Retrofit API Call
      ↓
JSON Response
      ↓
imageList Updated
      ↓
Compose Recomposition
      ↓
LazyVerticalGrid Displays Images
*/


class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApp()         // Compose UI starts here.
        }
    }
}

/*
    Applies Material Design theme.
*/
@Composable
fun MyApp() {
    MaterialTheme {
        imageScreen()   //   Displays screen without running app.
    }
}

/*
    Shows preview in Android Studio.
*/
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun imageScreen(){
    // Acts as screen entry point.
//    ImageGrid()

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text("Image Gallery")
                }
            )
        }
    ) { paddingValues ->
        ImageGrid(
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun ImageGrid( modifier: Modifier = Modifier,
    viewModel: ImageViewModel = viewModel()) {   // Gets ViewModel instance.

    // Observes state.
    val images = viewModel.imageList

    // Creates scrollable grid.
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),        // 2 columns
        contentPadding = PaddingValues(8.dp)   // Adds spacing around grid.
    ) {
        items(images) { item ->       //  Loops through image list.

            // Creates card container.
            Card(
                modifier = Modifier
                    .padding(8.dp)      // Space between cards.
                    .fillMaxWidth()          // Occupies available width.
            ) {
                // Loads image from URL. (Coil)
                /*
                    Coil handles: Download, Cache, Memory optimization
                */
                AsyncImage(
                    model = item.imageUrl,
                    contentDescription = null,        // Accessibility description.
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth(),               //  Image size.
                    contentScale = ContentScale.Crop   // Fills image area.
                )
            }
        }
    }
}
