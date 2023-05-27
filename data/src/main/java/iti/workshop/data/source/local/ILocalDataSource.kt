package iti.workshop.data.source.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import iti.workshop.data.source.dto.Article
import kotlinx.coroutines.flow.Flow

interface ILocalDataSource{

    fun getArticles(): Flow<List<Article>>

    suspend fun insertArticle(article: Article)

    suspend fun deleteArticle(article: Article)

    fun isExists(title: String): Flow<Boolean>

}