package com.example.timer.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CoinsItem::class], version = 1)
abstract class CoinsDatabase : RoomDatabase() {

    abstract fun coinsDao(): CoinsDao

    companion object {
        @Volatile
        private var instance: CoinsDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            CoinsDatabase::class.java,
            "coindatabase"
        ).build()
    }
}