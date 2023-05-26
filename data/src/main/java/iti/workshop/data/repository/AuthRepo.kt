package iti.workshop.data.repository

import iti.workshop.data.source.remote.retrofit.RetrofitInstance
import iti.workshop.domain.models.reg.RegBody
import iti.workshop.domain.repository.AuthenticationRepo

class AuthRepo(val remoteDAtaSource: RetrofitInstance,val body:RegBody):AuthenticationRepo {
    override suspend fun regUser(body: RegBody):Boolean {
        val reg= remoteDAtaSource.api.register(body)
        return reg?.displayName!=null
    }
}