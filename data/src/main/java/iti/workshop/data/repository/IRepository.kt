package iti.workshop.data.repository

import android.content.Context
import iti.workshop.data.source.dto.Article
import iti.workshop.data.source.local.ILocalDataSource
import iti.workshop.data.source.remote.IRemoteDataSource
import kotlinx.coroutines.flow.Flow

interface IRepository{
    fun login(username:String, password:String)

    fun signUp()

    fun logout()



    fun getArticles(): Flow<List<Article>>

    suspend fun insertArticle(article: Article)

    suspend fun deleteArticle(article: Article)

    fun isExists(title: String): Flow<Boolean>

}