package com.example.restoranapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.example.restoranapp.data.PreferenceManager
import com.example.restoranapp.ui.navigation.NavGraph
import com.example.restoranapp.ui.theme.RestoranAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val prefManager = PreferenceManager(this)
        
        enableEdgeToEdge()
        setContent {
            var isDarkMode by remember { mutableStateOf(prefManager.isDarkMode()) }
            
            RestoranAppTheme(darkTheme = isDarkMode) {
                val navController = rememberNavController()
                NavGraph(
                    navController = navController,
                    prefManager = prefManager,
                    isDarkMode = isDarkMode,
                    onThemeToggle = { dark ->
                        isDarkMode = dark
                        prefManager.setDarkMode(dark)
                    }
                )
            }
        }
    }
}
