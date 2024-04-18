package com.example.tv_application_practice.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tv_application_practice.dataModel.DataModel
import com.example.tv_application_practice.utils.Constants
import com.example.tv_application_practice.utils.Constants.API_KEY


class NewsRepository(private val service: ApiService) {

    //technology news
    private val technologyNewsData = MutableLiveData<Response<DataModel>>()
    val technologyNews: LiveData<Response<DataModel>>
        get() = technologyNewsData

    suspend fun getTechnologyNewsDataNewsDetails(){
        try {
            val result = service.getNewsHeadlines(API_KEY,Constants.CATEGORY_TECHNOLOGY);
            if(result.body() != null)
            {
                technologyNewsData.postValue(Response.Success(result.body()))
            }else {
                technologyNewsData.postValue(Response.Error(result.errorBody().toString()))
            }
        }catch (e:Exception){
            Log.d("crashHandleNewsRepo",e.toString())

        }
    }

    //sports news
    private val sportsNewsData = MutableLiveData<Response<DataModel>>()
    val sportsNews: LiveData<Response<DataModel>>
        get() = sportsNewsData

    suspend fun getSportsNewsDetails(){
        try {
            val result = service.getNewsHeadlines(API_KEY,Constants.CATEGORY_SPORTS);
            if(result.body() != null)
            {
                sportsNewsData.postValue(Response.Success(result.body()))
            }else {
                sportsNewsData.postValue(Response.Error(result.errorBody().toString()))
            }
        }catch (e:Exception){
            Log.d("crashHandleNewsRepo",e.toString())

        }
    }




    //Science news
    private val scienceNewsData = MutableLiveData<Response<DataModel>>()
    val scienceNews: LiveData<Response<DataModel>>
        get() = scienceNewsData

    suspend fun getScienceNewsDetails(){
        try {
            val result = service.getNewsHeadlines(API_KEY,Constants.CATEGORY_SCIENCE);
            if(result.body() != null)
            {
                scienceNewsData.postValue(Response.Success(result.body()))
            }else {
                scienceNewsData.postValue(Response.Error(result.errorBody().toString()))
            }
        }catch (e:Exception){
            Log.d("crashHandleNewsRepo",e.toString())

        }
    }




    //Health news
    private val healthNewsData = MutableLiveData<Response<DataModel>>()
    val healthNews: LiveData<Response<DataModel>>
        get() = healthNewsData

    suspend fun getHealthNewsDetails(){
        try {
            val result = service.getNewsHeadlines(API_KEY,Constants.CATEGORY_HEALTH);
            if(result.body() != null)
            {
                healthNewsData.postValue(Response.Success(result.body()))
            }else {
                healthNewsData.postValue(Response.Error(result.errorBody().toString()))
            }
        }catch (e:Exception){
            Log.d("crashHandleNewsRepo",e.toString())

        }
    }




    //Entertainemnt news
    private val entertainmentNewsData = MutableLiveData<Response<DataModel>>()
    val entertainmentNews: LiveData<Response<DataModel>>
        get() = entertainmentNewsData

    suspend fun getEntertainmentNewsDetails(){
        try {
            val result = service.getNewsHeadlines(API_KEY,Constants.CATEGORY_ENTERTAINMENT);
            if(result.body() != null)
            {
                entertainmentNewsData.postValue(Response.Success(result.body()))
            }else {
                entertainmentNewsData.postValue(Response.Error(result.errorBody().toString()))
            }
        }catch (e:Exception){
            Log.d("crashHandleNewsRepo",e.toString())

        }
    }


    // General
    private val generalNewsData = MutableLiveData<Response<DataModel>>()
    val generalNews: LiveData<Response<DataModel>>
        get() = generalNewsData

    suspend fun getGeneralNews() {
        try {
            val result = service.getNewsHeadlines(API_KEY,Constants.CATEGORY_GENERAL);
            if(result.body() != null)
            {
                generalNewsData.postValue(Response.Success(result.body()))

            }else {
                generalNewsData.postValue(Response.Error(result.errorBody().toString()))
            }
        }catch (e:Exception){
            Log.d("crashHandleNewsRepo",e.toString())

        }
    }


    // business news
    private val businessNewsData = MutableLiveData<Response<DataModel>>()
    val businessNews: LiveData<Response<DataModel>>
        get() = businessNewsData

    suspend fun getBusinessNews(){
        try {
            val result = service.getNewsHeadlines(API_KEY,Constants.CATEGORY_BUSINESS);
            if(result.body() != null)
            {
                businessNewsData.postValue(Response.Success(result.body()))
            }else {
                businessNewsData.postValue(Response.Error(result.errorBody().toString()))
            }
        }catch (e:Exception){
            Log.d("crashHandleNewsRepo",e.toString())

        }
    }




}