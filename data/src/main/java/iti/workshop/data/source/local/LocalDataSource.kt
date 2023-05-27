package iti.workshop.data.source.local

import iti.workshop.data.source.local.room.ArticlesDao

class LocalDataSource(private val dao:ArticlesDao) : ILocalDataSource {

}