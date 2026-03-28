package com.example.app_kotlin_hach.ui.linkedin

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun LinkedInScreen(){

    AndroidView(factory = { context ->
        WebView(context).apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl("https://mx.linkedin.com/in/horacio-castillo-hernandez-6a665b147")
        }


    })
}