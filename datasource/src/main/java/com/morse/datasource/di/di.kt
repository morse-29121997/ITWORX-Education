package com.morse.datasource.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.morse.datasource.BuildConfig
import com.morse.datasource.local.database.NewsDao
import com.morse.datasource.local.database.NewsDataBase
import com.morse.datasource.local.preference.NewsPreferenceManager
import com.morse.datasource.remote.NewsApis
import com.morse.datasource.repositories.NewsRepository
import com.morse.datasource.repositories.SessionRepository
import com.morse.domain.repositories.INewsRepository
import com.morse.domain.repositories.ISessionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class IoDispatcher

@InstallIn(SingletonComponent::class)
@Module
object CoroutinesDispatchersModule {

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}

@InstallIn(SingletonComponent::class)
@Module
object CoroutinesScopesModule {

    @Singleton
    @Provides
    fun providesCoroutineScope(
        @IoDispatcher defaultDispatcher: CoroutineDispatcher
    ): CoroutineScope = CoroutineScope(SupervisorJob() + defaultDispatcher)
}

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


    @Singleton
    @Provides
    fun provideNewsRepository(apis: NewsApis, db: NewsDao, scope: CoroutineScope): INewsRepository =
        NewsRepository(apis, db, scope)


    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClientBuilder: OkHttpClient.Builder,
    ): Retrofit {

        val okHttpClient = okHttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS).writeTimeout(
                5, TimeUnit.MINUTES
            ).build()

        return Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .enableComplexMapKeySerialization().serializeNulls()
                        .setPrettyPrinting().setVersion(1.0).setLenient().create()
                )
            )
            .baseUrl(BuildConfig.BASE_URL).build()
    }

    @Provides
    @Singleton
    fun provideOkHttpBuilder(): OkHttpClient.Builder {
        val client = OkHttpClient.Builder()
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val authorizationInterceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
            request.addHeader(
                "X-Api-Key", BuildConfig.KEY
            )
            request.addHeader("Accept", "application/json")
            request.addHeader("Content-Type", "application/json")
            val response = chain.proceed(request.build())
            return@Interceptor response
        }
        return client
            .addInterceptor(authorizationInterceptor)
            .addInterceptor(logInterceptor)

    }

    @Provides
    @Singleton
    fun provideNewsAPIs(retrofit: Retrofit): NewsApis = retrofit.create(NewsApis::class.java)

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): NewsDataBase {
        return Room.databaseBuilder(
            context,
            NewsDataBase::class.java,
            "news_database"
        ).build()
    }

    @Provides
    fun provideNewsDao(appDatabase: NewsDataBase): NewsDao {
        return appDatabase.newsDao()
    }

}