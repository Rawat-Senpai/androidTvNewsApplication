package com.example.tv_application_practice.api

import com.example.tv_application_practice.dataModel.DataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface  ApiService {



    @GET("top-headlines?country=In")
    suspend fun getNewsHeadlines(
        @Query("apiKey") apiKey: String,
        @Query("category") category: String
    ): Response<DataModel>




}