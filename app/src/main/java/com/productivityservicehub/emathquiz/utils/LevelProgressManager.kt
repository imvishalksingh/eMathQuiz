package com.productivityservicehub.emathquiz.utils

import android.content.Context
import android.content.SharedPreferences

object LevelProgressManager {
    private const val PREFS_NAME = "level_progress_prefs"
    private const val KEY_HIGHEST_LEVEL_COMPLETED = "highest_level_completed"

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun getHighestLevelCompleted(context: Context): Int {
        return getPrefs(context).getInt(KEY_HIGHEST_LEVEL_COMPLETED, 0)
    }

    fun setHighestLevelCompleted(context: Context, level: Int) {
        getPrefs(context).edit().putInt(KEY_HIGHEST_LEVEL_COMPLETED, level).apply()
    }
}