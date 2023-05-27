package iti.workshop.newApp.states

import iti.workshop.data.source.remote.models.news.Article

sealed class NewsState{
    class Success(data:List<iti.workshop.data.source.remote.models.news.Article>):NewsState()
    class Failure(val error:Throwable):NewsState()
    object Loading : NewsState()
}
