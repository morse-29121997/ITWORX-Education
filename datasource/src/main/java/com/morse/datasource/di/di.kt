package com.morse.datasource.di

import android.content.Context
import android.content.SharedPreferences
import com.morse.datasource.local.preference.NewsPreferenceManager
import com.morse.datasource.repositories.SessionRepository
import com.morse.domain.repositories.ISessionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("news_prefs", Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideNewsSharedPreference(sharedPreferences: SharedPreferences) =
        NewsPreferenceManager(sharedPreferences)

    @Singleton
    @Provides
    fun provideSessionRepository(preference: NewsPreferenceManager): ISessionRepository =
        SessionRepository(preference)
}