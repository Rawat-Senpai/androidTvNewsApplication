package com.example.tv_application_practice.webView

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.tv_application_practice.R


class WebViewActivity : AppCompatActivity() {

    private lateinit var webViewForNews:WebView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webViewForNews=findViewById(R.id.webViewForNews)

        val newsUrl= intent.getStringExtra("newsUrl")
        webViewForNews.loadUrl(newsUrl.toString())

    }
}