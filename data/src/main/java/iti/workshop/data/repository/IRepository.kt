package iti.workshop.data.repository

import android.content.Context
import iti.workshop.data.source.local.ILocalDataSource
import iti.workshop.data.source.remote.IRemoteDataSource

interface IRepository: ILocalDataSource, IRemoteDataSource {

}