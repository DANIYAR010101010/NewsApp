package com.io.muhsin.newsapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.muhsin.newsapp.data.api.NewsRepository
import com.io.muhsin.newsapp.models.NewsResponse
import com.io.muhsin.newsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {

    val newsLiveData: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var newsPage =1
    init {
        getNews("ru")
    }
    private fun getNews(countryCode:String)=

        viewModelScope.launch {
            newsLiveData.postValue(Resource.Loading())
            val response = repository.getNews(countryCode = countryCode, pageNumber = newsPage)
            if (response.isSuccessful){
                response.body().let { res->
                    newsLiveData.postValue(Resource.Succes(res))
                }
            }else{
                newsLiveData.postValue(Resource.Error(message = response.message()))
            }
        }

}