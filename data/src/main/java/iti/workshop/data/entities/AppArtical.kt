package iti.workshop.data.entities

import iti.workshop.domain.models.news.Source

data class AppArtical(val author: String,
                      val content: String,
                      val description: String,
                      val publishedAt: String,
                      val sourceID: String,
                      val sourceName:String,
                      val title: String,
                      val url: String,
                      val urlToImage: String)
