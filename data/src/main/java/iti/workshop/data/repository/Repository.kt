package iti.workshop.data.repository

import android.content.Context
import android.content.SharedPreferences
import iti.workshop.data.source.local.ILocalDataSource
import iti.workshop.data.source.remote.IRemoteDataSource
import iti.workshop.data.source.shared.SharedManager

class Repository(
    val context: Context,
    val local: ILocalDataSource,
    val remote: IRemoteDataSource
) : IRepository {
    override fun login(username: String, password: String) {
        TODO("Not yet implemented")
    }


    override fun signUp() {
        TODO("Not yet implemented")
    }

    override fun logout() {
        TODO("Not yet implemented")
    }


    fun savedLoginData(userId:String, name:String){
        SharedManager.getInstance(context)?.let {
            it.saveUser(userId,name)
        }
    }
}