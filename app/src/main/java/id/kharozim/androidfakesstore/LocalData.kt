package id.kharozim.androidfakesstore

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class LocalData(private val context: Context) {

    companion object {
        const val NAME = "name local sharedprefered"
        const val KEY_ITEM_RECYCLERVIEW = "KEY_ITEM_RECYCLERVIEW"
        const val KEY_CHECKOUT = "KEY_CHECKOUT"
    }

    private val sharedPreferences by lazy {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
    }

    private inline fun <reified T> SharedPreferences.save(key: String, value: T) {
        edit {
            when (value) {
                is Int -> putInt(key, value)
                is String -> putString(key, value)
                is Float -> putFloat(key, value)
                is Boolean -> putBoolean(key, value)
                is Long -> putLong(key, value)
                is Set<*> -> putStringSet(key, value as? Set<String> ?: setOf())
            }
        }
    }




    var checkoutArray :Array<String>
    get() = sharedPreferences.getStringSet(KEY_CHECKOUT, emptySet())?.toTypedArray()?: emptyArray()
    set(value) = sharedPreferences.edit { putStringSet(KEY_CHECKOUT, value.toSet()) }







    fun setitem(data: Set<String>){
        sharedPreferences.save(KEY_ITEM_RECYCLERVIEW, data)
    }

    fun addItem(data: String){
        val item = getItem().toMutableList().apply {  }.toSet()
        sharedPreferences.save(KEY_ITEM_RECYCLERVIEW, item)
    }

    private fun getItem(): Set<String> {
        return sharedPreferences.getStringSet(KEY_ITEM_RECYCLERVIEW, setOf())?: setOf()
    }
}