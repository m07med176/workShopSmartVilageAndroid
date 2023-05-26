package iti.workshop.data.source.shared

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

const val SHARE_KEY = "shared_user_data"
const val USER_ID = "id"
const val USER_NAME = "name"
const val USER_EMAIL = "email"

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

    fun clearAllData() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    fun saveUser(userId:String, name:String,email:String) {
        val editor = sharedPreferences.edit()
        editor.putString(USER_ID,userId)
        editor.putString(USER_NAME,name)
        editor.putString(USER_EMAIL,email)
        editor.apply()
    }


    val isUser: Boolean
        get() = sharedPreferences.contains(USER_ID)

}

