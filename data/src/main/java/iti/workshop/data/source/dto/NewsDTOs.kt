package iti.workshop.data.source.dto

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "article")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)

data class Source(
    val id: String,
    val name: String
)