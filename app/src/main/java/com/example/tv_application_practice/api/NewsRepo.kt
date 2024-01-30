package com.example.tv_application_practice.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tv_application_practice.dataModel.DataModel
import com.example.tv_application_practice.utils.Constants.API_KEY


class NewsRepo(val service: ApiService) {


    private val detailData = MutableLiveData<Response<DataModel>>()

    private val techDataNews = MutableLiveData<Response<DataModel>>()

    val newsDetail: LiveData<Response<DataModel>>
        get() = detailData


    suspend fun getNewsDetails(){
        try {
            val result = service.getAllBusinessHealines(API_KEY);
            if(result.body() != null)
            {
                try {
                    Log.d("TAG", "tgX6Values: " + result.body().toString())
//                    Log.d("checkingResponse",result.body().toString());
                }catch (e:Exception){
                    Log.d("apiCrashHandle",e.toString())
                }

                detailData.postValue(Response.Success(result.body()))

            }else {
                detailData.postValue(Response.Error(result.errorBody().toString()))
            }
        }catch (e:Exception){
            Log.d("crashHandleNewsRepo",e.toString())

        }
    }


    suspend fun getTechNewsDetails(){
        try {
            val result = service.getAllTechHeadlines(API_KEY);
            if(result.body() != null)
            {
                try {
                    Log.d("TAG", "tgX6Values: " + result.body().toString())
//                    Log.d("checkingResponse",result.body().toString());
                }catch (e:Exception){
                    Log.d("apiCrashHandle",e.toString())
                }

                techDataNews.postValue(Response.Success(result.body()))

            }else {
                techDataNews.postValue(Response.Error(result.errorBody().toString()))
            }
        }catch (e:Exception){
            Log.d("crashHandleNewsRepo",e.toString())

        }
    }

}