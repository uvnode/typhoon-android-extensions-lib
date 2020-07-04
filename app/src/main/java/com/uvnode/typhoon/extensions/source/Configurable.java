package com.uvnode.typhoon.extensions.source;

import android.content.SharedPreferences;

import androidx.preference.PreferenceScreen;

public interface Configurable {

    void addPreferences(PreferenceScreen preferences);

    void setSharedPreferences(SharedPreferences sharedPreferences);
}
