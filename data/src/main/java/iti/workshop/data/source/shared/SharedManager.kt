package iti.workshop.data.source.shared

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class SharedManager private constructor(context: Context) {
    private var sharedPreferences: SharedPreferences? = null
    val SHARE_KEY = "shareRoom"

    companion object {
        const val IS_FIRST = "IS_FIRST"
        const val USER_INFO = "USER_INFO"

        @Volatile
        private var instance: SharedManager? = null
        fun getInstance(context: Context): SharedManager? {
            if (instance == null) instance = SharedManager(context)
            return instance
        }
    }
    init {
        sharedPreferences = context.getSharedPreferences(SHARE_KEY, Context.MODE_PRIVATE)
    }

    fun clearAllData() {
        val editor = sharedPreferences!!.edit()
        editor.clear()
        editor.apply()
    }

    fun saveUser(userId:String, name:String) {
        val editor = sharedPreferences!!.edit()
        editor.putString("userId",userId)
        editor.putString("name",name)
        editor.apply()
    }


}