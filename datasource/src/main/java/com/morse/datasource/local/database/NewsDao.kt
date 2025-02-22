package com.morse.datasource.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: NewEntity)

    @Query("SELECT * FROM favourite_news")
    suspend fun getAllNews(): List<NewEntity>

    @Query("SELECT EXISTS(SELECT * FROM favourite_news WHERE url = :url)")
    suspend fun isExist (url : String) : Boolean

    @Query("DELETE FROM favourite_news WHERE url = :url")
    suspend fun delete(url : String)

}