package com.morse.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [NewEntity::class], version = 2)
abstract class NewsDataBase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}