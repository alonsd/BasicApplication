package com.basicapplication.utils.extensions

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import com.basicapplication.utils.constants.SharedPreferences.BASIC_APPLICATIONS_SHARED_PREFERENCES

class SharedPreferencesExtensions {

//    var SharedPreferences.testerUsername
//        get() = getString(TESTER_USERNAME, "")
//        set(value) {
//            editSharedPreferences { editor ->
//                editor.put(TESTER_USERNAME to value)
//            }
//        }

    val Fragment.sharedPreferences: SharedPreferences
        get() =
            requireActivity().getSharedPreferences(BASIC_APPLICATIONS_SHARED_PREFERENCES, MODE_PRIVATE)

    val Activity.sharedPreferences: SharedPreferences
        get() =
            getSharedPreferences(BASIC_APPLICATIONS_SHARED_PREFERENCES, MODE_PRIVATE)

    private inline fun SharedPreferences.editSharedPreferences(operation: (SharedPreferences.Editor) -> Unit) {
        val editSharePreferences = edit()
        operation(editSharePreferences)
        editSharePreferences.apply()
    }

    private fun SharedPreferences.Editor.put(pair: Pair<String, Any?>) {
        val key = pair.first
        when (val value = pair.second) {
            is String -> putString(key, value)
            is Int -> putInt(key, value)
            is Boolean -> putBoolean(key, value)
            is Long -> putLong(key, value)
            is Float -> putFloat(key, value)
        }
    }
}