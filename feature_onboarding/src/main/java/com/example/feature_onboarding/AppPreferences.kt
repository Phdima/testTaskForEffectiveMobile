package com.example.feature_onboarding

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferences @Inject constructor(
    @ApplicationContext context: Context
) {
    private val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    var isFirstLaunch: Boolean
        get() = prefs.getBoolean(FIRST_LAUNCH_KEY, true)
        set(value) = prefs.edit().putBoolean(FIRST_LAUNCH_KEY, value).apply()

    companion object {
        private const val FIRST_LAUNCH_KEY = "is_first_launch"
    }
}