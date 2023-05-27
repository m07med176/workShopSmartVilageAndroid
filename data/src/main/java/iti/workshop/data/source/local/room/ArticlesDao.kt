package iti.workshop.data.source.local.room

import androidx.room.*
import iti.workshop.data.source.dto.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticlesDao {

    @Query("SELECT * FROM article")
    fun getArticles(): Flow<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: Article)

    @Delete
    suspend fun deleteArticle(article: Article)

    @Query("SELECT EXISTS(SELECT 1 FROM article WHERE title = :title)")
    fun isExists(title: String): Flow<Boolean>
}
