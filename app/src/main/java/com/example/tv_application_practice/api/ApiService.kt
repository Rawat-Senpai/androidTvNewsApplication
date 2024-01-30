package com.example.tv_application_practice.api

import com.example.tv_application_practice.dataModel.DataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface  ApiService {
/*
https://newsapi.org/v2/top-headlines?country=In&category=business&apiKey=1f2e109c082d4ee4b2ad94f523c1f220
 */
//    // business headlines
//    @GET("top-headlines?country=In&category=business")
//    suspend fun getAllBusinessHealines(@Query("apiKey") apiKey:String) : Response<DataModel>
//
//    // tech headlines
//    @GET("top-headlines?sources=techcrunch")
//    suspend fun getAllTechHeadlines(@Query("apiKey") apiKey:String) : Response<DataModel>




    @GET("top-headlines?country=In")
    suspend fun getNewsHeadlines(
        @Query("apiKey") apiKey: String,
        @Query("category") category: String
    ): Response<DataModel>




}