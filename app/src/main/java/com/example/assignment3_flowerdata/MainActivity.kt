package com.example.assignment3_flowerdata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.assignment3_flowerdata.ui.AppRootScreen
import com.example.assignment3_flowerdata.ui.theme.Assignment3FlowerDataTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment3FlowerDataTheme {
                AppRootScreen()
            }
        }
    }
}
