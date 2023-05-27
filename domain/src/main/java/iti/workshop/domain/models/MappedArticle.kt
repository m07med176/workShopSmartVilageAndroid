package iti.workshop.domain.models

import iti.workshop.data.source.remote.models.news.Source

data class MappedArticle(val author: String,
                         val content: String,
                         val description: String,
                         val publishedAt: String,
                         val sourceID: String,
                         val sourceName:String,
                         val title: String,
                         val url: String,
                         val urlToImage: String)
