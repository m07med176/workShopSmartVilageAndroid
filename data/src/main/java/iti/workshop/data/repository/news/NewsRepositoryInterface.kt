package iti.workshop.data.repository.news



import iti.workshop.data.source.dto.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepositoryInterface {
    suspend fun getNews(apiKey:String, country:String): Flow<List<Article>>
    fun getArticles(): Flow<List<Article>>
    suspend fun insertArticle(article: Article)
    suspend fun deleteArticle(article: Article)
    fun isExists(title: String): Flow<Boolean>
}