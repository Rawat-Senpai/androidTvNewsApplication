package com.example.tv_application_practice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tv_application_practice.api.NewsRepo
import com.example.tv_application_practice.api.Response
import com.example.tv_application_practice.dataModel.DataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(val repo:NewsRepo): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getNewsDetails()
        }
    }

    val newsDetail:LiveData<Response<DataModel>>
        get() = repo.newsDetail
}