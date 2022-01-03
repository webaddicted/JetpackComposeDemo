package com.webaddicted.jetpackcomposedemo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.webaddicted.jetpackcomposedemo.utils.constant.ApiConstant

@Database(entities = [UserEntity::class], version = ApiConstant.DB_VERSION,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todayBeatDao(): UserDao
}