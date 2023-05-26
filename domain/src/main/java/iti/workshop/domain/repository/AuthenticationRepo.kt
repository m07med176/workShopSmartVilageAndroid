package iti.workshop.domain.repository

import iti.workshop.domain.models.reg.RegBody

interface AuthenticationRepo {
    suspend fun regUser(body: RegBody):Boolean
}