package br.com.redesenhe.redesenhe.service.repository.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class RedesenheDatabase : RoomDatabase() {

    companion object {
        private lateinit var INSTANCE: RedesenheDatabase

        fun getDatabase(context: Context): RedesenheDatabase {
            if (!Companion::INSTANCE.isInitialized) {
                synchronized(RedesenheDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context, RedesenheDatabase::class.java, "redesenheDB")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}