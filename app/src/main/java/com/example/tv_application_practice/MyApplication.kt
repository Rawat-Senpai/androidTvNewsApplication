package com.example.tv_application_practice

import android.app.Application
import com.example.tv_application_practice.api.ApiService
import com.example.tv_application_practice.api.NewsRepo
import com.example.tv_application_practice.api.RetrofitHelper

class MyApplication :Application() {

    lateinit var newsRepo: NewsRepo

    override fun onCreate() {
        super.onCreate()

        init()
    }

    private fun init(){
        val service = RetrofitHelper.getInstance().create(ApiService::class.java)
        newsRepo = NewsRepo(service)
    }
}