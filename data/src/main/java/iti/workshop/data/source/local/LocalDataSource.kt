package iti.workshop.data.source.local

import iti.workshop.data.source.dto.Article
import iti.workshop.data.source.local.room.ArticlesDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val dao:ArticlesDao) : ILocalDataSource {
    override fun getArticles(): Flow<List<Article>>  = dao.getArticles()

    override suspend fun insertArticle(article: Article) {
        dao.insertArticle(article)
    }

    override suspend fun deleteArticle(article: Article)  {
        dao.deleteArticle(article)
    }

    override fun isExists(title: String): Flow<Boolean>  = dao.isExists(title)

}