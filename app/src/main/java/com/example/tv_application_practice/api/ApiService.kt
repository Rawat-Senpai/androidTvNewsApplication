package com.example.tv_application_practice.api

import com.example.tv_application_practice.dataModel.DataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface  ApiService {
/*
https://newsapi.org/v2/top-headlines?country=In&category=business&apiKey=1f2e109c082d4ee4b2ad94f523c1f220
 */
    @GET("top-headlines?country=In&category=business")
    suspend fun getAllData(@Query("apiKey") apiKey:String) : Response<DataModel>


}