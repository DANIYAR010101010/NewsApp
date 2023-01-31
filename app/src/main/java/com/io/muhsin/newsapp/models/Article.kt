package com.io.muhsin.newsapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article")
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    var author: String? = null,
    var content: String? = null,
    var description: String? = null,
    var publishedAt: String? = null,
    var source: Source? = null,
    var title: String? = null,
    var url: String? = null,
    var urlToImage: String? = null
)