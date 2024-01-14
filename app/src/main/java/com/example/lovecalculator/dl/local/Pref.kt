package com.example.lovecalculator.dl.local

import android.content.Context
import android.content.SharedPreferences

class Pref(context: Context) {
    private val pref: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun setOnBoardingComplete() {
        pref.edit().putBoolean(SHOWED_KEY, true).apply()
    }

    fun onShow(): Boolean {
        return pref.getBoolean(SHOWED_KEY, false)
    }

    companion object {
        const val PREF_NAME="name"
        const val SHOWED_KEY="key"
    }
}
