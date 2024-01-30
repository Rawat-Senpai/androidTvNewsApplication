package com.example.tv_application_practice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tv_application_practice.api.NewsRepo

class DetailViewModelFactory(val repository: NewsRepo):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(repository) as T
    }

}