package iti.workshop.data.source.remote.models.news

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)