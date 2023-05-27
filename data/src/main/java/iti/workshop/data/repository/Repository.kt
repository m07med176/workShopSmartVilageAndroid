package iti.workshop.data.repository

import iti.workshop.data.source.dto.Article
import iti.workshop.data.source.dto.User
import iti.workshop.data.source.local.ILocalDataSource
import iti.workshop.data.source.remote.IRemoteDataSource
import iti.workshop.data.source.shared.SharedManager
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class Repository(
    val shared: SharedManager,
    val local: ILocalDataSource,
    val remote: IRemoteDataSource,
    val dispatcher:CoroutineDispatcher = Dispatchers.IO
) : IRepository {
    override fun login(username: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun signUp() {
        TODO("Not yet implemented")
    }

    override fun logout() {
        TODO("Not yet implemented")
    }

    override fun getArticles(): Flow<List<Article>>  = local.getArticles().flowOn(dispatcher)

    override suspend fun insertArticle(article: Article) {
        withContext(dispatcher){
            local.insertArticle(article)
        }
    }

    override suspend fun deleteArticle(article: Article) {
        withContext(dispatcher){
            local.deleteArticle(article)
        }
    }

    override  fun isExists(title: String): Flow<Boolean>  = local.isExists(title).flowOn(Dispatchers.IO)


    fun savedLoginData(user:User){
        shared.saveUser(user)
    }
}