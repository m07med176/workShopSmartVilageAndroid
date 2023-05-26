package iti.workshop.data.source.shared

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import iti.workshop.data.source.dto.User

const val SHARE_KEY = "shared_user_data"
const val USER_INFO = "USER_INFO"
class SharedManager private constructor(context: Context) {
    private val sharedPreferences: SharedPreferences by lazy { context.getSharedPreferences(SHARE_KEY, Context.MODE_PRIVATE)}



    companion object {
        @Volatile
        private var instance: SharedManager? = null
        fun getInstance(context: Context): SharedManager? {
            synchronized(this){
                if (instance == null) instance = SharedManager(context)
                return instance
            }
        }
    }

    fun clearUser() {
        val editor = sharedPreferences.edit()
        editor.remove(USER_INFO)
        editor.apply()
    }


    fun saveUser(user: User?) {
        val editor = sharedPreferences.edit()
        editor.putString(USER_INFO, Gson().toJson(user))
        editor.apply()

    }


    fun getUser(): User {
        val userStr = sharedPreferences.getString(USER_INFO, null)
        var user = User()
        if (userStr != null) {
            user = Gson().fromJson(userStr, User::class.java)
        }
        return user
    }

    fun isUserSavedLogging(): Boolean{
        return sharedPreferences.contains(USER_INFO)
    }
}


