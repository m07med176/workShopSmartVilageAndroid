package iti.workshop.data

import iti.workshop.data.entities.AppArtical
import iti.workshop.domain.models.news.Article

object MappersUtil {
    fun mapFromArticaltoMapArtical(article: Article):AppArtical{
        return AppArtical(article.author,article.content,article.description,article.publishedAt,article.source.id,article.source.name,article.title,article.url,article.urlToImage)

    }

    fun mapFromListArticaltoListAppArtical(articals:List<Article>):List<AppArtical>{
        var listArticle= mutableListOf<AppArtical>()
        for (article in articals){
            listArticle.add(AppArtical(article.author,article.content,article.description,article.publishedAt,article.source.id,article.source.name,article.title,article.url,article.urlToImage))
        }
        return listArticle
    }

}