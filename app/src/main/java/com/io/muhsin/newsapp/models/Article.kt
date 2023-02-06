package com.io.muhsin.newsapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "article")
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id : Int?,
    var author: String?,
    var content: String?,
    var description: String?,
    var publishedAt: String?,
    var title: String?,
    var url: String?,
    var urlToImage: String?
):Serializable