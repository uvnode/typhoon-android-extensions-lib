package com.uvnode.typhoon.extensions.source

import android.content.SharedPreferences
import androidx.preference.PreferenceScreen

interface Configurable {
    fun addPreferences(preferences: PreferenceScreen?)
    fun setSharedPreferences(sharedPreferences: SharedPreferences?)
}