import iti.workshop.data.repository.IRepository
import iti.workshop.data.source.dto.Article
import iti.workshop.data.source.dto.User
import iti.workshop.data.source.local.ILocalDataSource
import iti.workshop.data.source.shared.SharedManager
import kotlinx.coroutines.flow.Flow

class Repository(
    val shared: SharedManager,
    val local: ILocalDataSource,
    //val remote: IRemoteDataSource
) : IRepository {

    override fun getArticles(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertArticle(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteArticle(article: Article) {
        TODO("Not yet implemented")
    }

    override fun isExists(title: String): Flow<Boolean> {
        TODO("Not yet implemented")
    }


    fun savedLoginData(user: User){
        shared.saveUser(user)
    }
}