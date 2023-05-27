package iti.workshop.data.repository

interface IRepository{
    fun login(username:String, password:String)

    fun signUp()

    fun logout()



}