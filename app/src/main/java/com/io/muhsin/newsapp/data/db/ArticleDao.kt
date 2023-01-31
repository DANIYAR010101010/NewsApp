package com.io.muhsin.newsapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.io.muhsin.newsapp.models.Article

@Dao
interface ArticleDao {

    @Query("SELECT * FROM article")
    suspend fun getAllArticles(): LiveData<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Delete
    suspend fun delete(article: Article)
}