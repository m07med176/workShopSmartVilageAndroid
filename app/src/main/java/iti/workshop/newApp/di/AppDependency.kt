package iti.workshop.newApp.di

import android.content.Context
import iti.workshop.data.repository.IRepository
import iti.workshop.data.repository.Repository
import iti.workshop.data.source.local.ILocalDataSource
import iti.workshop.data.source.local.LocalDataSource
import iti.workshop.data.source.local.room.RoomDB
import iti.workshop.data.source.remote.IRemoteDataSource
import iti.workshop.data.source.remote.RemoteDataSource
import iti.workshop.data.source.remote.retrofit.CallApi
import iti.workshop.data.source.remote.retrofit.RetrofitInstance
import iti.workshop.data.source.shared.SharedManager
import iti.workshop.domain.usecases.*

object AppDependency {

    lateinit var insetFavorite: InsertFavorite
    lateinit var getNews:GetNews
    lateinit var deleteFavorite: DeleteFavorite
    lateinit var checkFavoriteExist: CheckFavoriteExist
    lateinit var getFavorites:GetFavorites

    fun initialization(appContext: Context){

        val callApi : CallApi = RetrofitInstance.api
        val remote = RemoteDataSource(callApi)
        val db = RoomDB.invoke(appContext).articleDao()
        val local = LocalDataSource(db)
        val sharedManager = SharedManager.getInstance(appContext)!!
        val repo = Repository(sharedManager,local,remote)

        insetFavorite = InsertFavorite(repo)
        deleteFavorite = DeleteFavorite(repo)
        getFavorites = GetFavorites(repo)
        checkFavoriteExist = CheckFavoriteExist(repo)
        getNews = GetNews()
    }


}