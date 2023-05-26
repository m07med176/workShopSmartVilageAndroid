package iti.workshop.data.repository

import android.content.Context
import iti.workshop.data.source.local.ILocalDataSource
import iti.workshop.data.source.remote.IRemoteDataSource

class Repository(
    override val context: Context,
    override val local: ILocalDataSource,
    override val remote: IRemoteDataSource
) : IRepository {
}