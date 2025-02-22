package com.morse.news.app

import android.app.Application
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApp : MultiDexApplication() {
}