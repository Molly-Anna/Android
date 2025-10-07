package com.example.esteticfilms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.esteticfilms.ui.theme.EsteticFilmsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EsteticFilmsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {

                }
            }
        }
    }
}

//Основная активность.
@Composable
fun ViewingSelectionOfMovies() {

}


@Preview(showBackground = true)
@Composable
fun ViewingSelectionOfMoviesPreviw(){
    EsteticFilmsTheme {
        ViewingSelectionOfMovies()
    }
}

