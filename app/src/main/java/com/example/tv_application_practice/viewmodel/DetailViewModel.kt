package com.example.tv_application_practice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tv_application_practice.api.NewsRepository
import com.example.tv_application_practice.api.Response
import com.example.tv_application_practice.dataModel.DataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DetailViewModel(private val repository: NewsRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {

            repository.getGeneralNews()
            repository.getTechnologyNewsDataNewsDetails()
            repository.getBusinessNews()
            repository.getHealthNewsDetails()
            repository.getScienceNewsDetails()
            repository.getEntertainmentNewsDetails()
            repository.getSportsNewsDetails()

        }
    }

    val generalDetails: LiveData<Response<DataModel>> get() = repository.generalNews

    val techNewsDetail: LiveData<Response<DataModel>> get() = repository.technologyNews

    val businessNewsDetail: LiveData<Response<DataModel>> get() = repository.businessNews

    val healthDetail: LiveData<Response<DataModel>> get() = repository.healthNews

    val scienceDetail: LiveData<Response<DataModel>> get() = repository.scienceNews

    val entertainmentDetail: LiveData<Response<DataModel>> get() = repository.entertainmentNews

    val sportsDetail: LiveData<Response<DataModel>> get() = repository.sportsNews
}
