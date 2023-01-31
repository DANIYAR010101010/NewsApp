package com.io.muhsin.newsapp.models

data class NewsResponse(
    var articles: List<Article?>? = null,
    var status: String? = null,
    var totalResults: Int? = null
)