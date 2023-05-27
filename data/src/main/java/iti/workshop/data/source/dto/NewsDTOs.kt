package iti.workshop.data.source.dto

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "article")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val author: String?=null,
    val content: String?=null,
    val description: String?=null,
    val publishedAt: String?=null,
    val title: String?=null,
    val url: String?=null,
    val urlToImage: String?=null
):Serializable

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)

data class Source(
    val id: String,
    val name: String
)