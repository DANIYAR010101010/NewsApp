package com.io.muhsin.newsapp.utils

import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.io.muhsin.newsapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay

class Constants {
    companion object{
        const val BASE_URL = "https://newsapi.org/"
        const val API_KEY = "83e28c5a1c3f4951833f20d9c095b06c"
    }

}