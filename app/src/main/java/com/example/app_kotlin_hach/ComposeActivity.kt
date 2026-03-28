package com.example.app_kotlin_hach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.foundation.isSystemInDarkTheme
import com.example.app_kotlin_hach.navigation.AppNavigation
import com.example.app_kotlin_hach.ui.theme.AppTheme

class ComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {


            val systemDark = isSystemInDarkTheme()
            var darkMode by remember { mutableStateOf(systemDark) }

            AppTheme(darkTheme = darkMode) {

                AppNavigation(
                    onToggleTheme = {
                        darkMode = !darkMode
                    }
                )
            }
        }
    }
}