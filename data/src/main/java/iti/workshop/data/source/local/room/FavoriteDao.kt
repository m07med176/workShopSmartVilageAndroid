package iti.workshop.data.source.local.room

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

//    @Query("SELECT * FROM cash_table WHERE cityName =:cityName")
//    fun getCash(cityName:String): Flow<FavoriteDao>
//
//    @Upsert
//    suspend fun insertCash(cash: FavoriteDao)
//
//    @Query("DELETE FROM cash_table WHERE createdAt < :createdAt")
//    suspend fun deleteCash(createdAt: Long)


}