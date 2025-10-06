package com.example.ytcleanplay

import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webview)
        val ws: WebSettings = webView.settings
        ws.javaScriptEnabled = true
        ws.mediaPlaybackRequiresUserGesture = false
        ws.domStorageEnabled = true
        ws.allowFileAccess = true

        webView.webChromeClient = WebChromeClient()

        // Load local HTML (player.html) from assets
        webView.loadUrl("file:///android_asset/player.html")

        // Start foreground service to keep audio focus when user wants background play
        val svc = Intent(this, AudioForegroundService::class.java)
        startForegroundService(svc)
    }

    override fun onPause() {
        super.onPause()
        // Keep WebView alive; do NOT call webView.onPause() if you want audio to continue.
    }

    override fun onDestroy() {
        super.onDestroy()
        webView.destroy()
    }
}
