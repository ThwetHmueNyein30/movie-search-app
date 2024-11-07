package com.thn.codingassessment.android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MovieSearchApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.ENABLE_LOGGER) {
            Timber.plant(Timber.DebugTree())
        }
    }
}