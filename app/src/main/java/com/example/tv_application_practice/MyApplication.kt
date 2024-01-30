package com.example.tv_application_practice

import android.app.Application
import com.example.tv_application_practice.api.ApiService
import com.example.tv_application_practice.api.NewsRepository
import com.example.tv_application_practice.api.RetrofitHelper

class MyApplication :Application() {

    lateinit var newsRepo: NewsRepository

    override fun onCreate() {
        super.onCreate()

        init()
    }

    private fun init(){
        val service = RetrofitHelper.getInstance().create(ApiService::class.java)
        newsRepo = NewsRepository(service)
    }
}