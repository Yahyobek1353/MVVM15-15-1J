package com.geeks.mvvm15_1j.data.shared

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Prefs(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("prefs", MODE_PRIVATE)


}