package iti.workshop.domain.repository

import iti.workshop.domain.models.news.Article
import iti.workshop.domain.models.news.NewsResponse
import iti.workshop.domain.models.reg.RegBody
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface {
    suspend fun getNews(apiKey:String, country:String): Flow<List<Article>>

}


//   @POST(Constants.REGISTER_API_URL + "?" + Constants.REGISTER_API_KEY)
//    suspend fun register(
//        @Body body: RegBody
//
//    ): RegisterationResponse