package com.io.muhsin.newsapp.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.muhsin.newsapp.data.api.NewsRepository
import com.io.muhsin.newsapp.models.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {
    init {
    getSavedArticles()
    }

    private fun getSavedArticles() = viewModelScope.launch(Dispatchers.IO) {
        val res = repository.getFavouriteArticles()
        println("DB size: ${res.size}")
        repository.getFavouriteArticles()
    }

    fun saveFavouriteArticle(article: Article) = viewModelScope.launch(Dispatchers.IO) {
        repository.addToFavourite(article = article)
    }
}