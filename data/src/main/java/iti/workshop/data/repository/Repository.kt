package iti.workshop.data.repository

import android.content.Context
import iti.workshop.data.source.local.ILocalDataSource
import iti.workshop.data.source.remote.IRemoteDataSource

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

}