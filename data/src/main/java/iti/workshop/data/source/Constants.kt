package iti.workshop.data.source

import iti.workshop.data.BuildConfig

object Constants {
    const val BASE_URL = "https://identitytoolkit.googleapis.com/"
    const val NEWS_URL="https://newsapi.org/v2/"
    const val REGISTER_API_URL = "/v1/accounts:signUp"
    const val LOGIN_API_URL="/v1/accounts:signInWithPassword"
    const val NEWS_API_KEY = BuildConfig.NEWS_API_KEY
    const val AUTH_API_KEY =BuildConfig.AUTH_API_KEY
    // Network and Room cash
    const val MAX_AGE = 7
    const val  MAX_AGE_MILLI = MAX_AGE * 24 * 60 * 60 * 1000
    const val WORKER_ID:Long = 2554
}