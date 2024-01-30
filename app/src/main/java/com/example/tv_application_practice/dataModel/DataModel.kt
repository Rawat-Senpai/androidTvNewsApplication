package com.example.tv_application_practice.dataModel

data class DataModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
){
    data class Article(
        val author: String,
        val content: String,
        val description: String,
        val publishedAt: String,
        val title: String,
        val url: String,
        val urlToImage: String
    )
}