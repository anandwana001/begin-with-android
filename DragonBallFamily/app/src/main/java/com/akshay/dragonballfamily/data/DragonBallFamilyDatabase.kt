package com.akshay.dragonballfamily.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by akshaynandwana on
 * 08, May, 2020
 **/

@Database(entities = [DragonBallEntity::class], version = 1)
abstract class DragonBallFamilyDatabase : RoomDatabase() {

    abstract fun dragonBallDao(): DragonBallDao

    companion object {

        @Volatile
        private var INSTANCE: DragonBallFamilyDatabase? = null

        fun getDatabase(context: Context): DragonBallFamilyDatabase {

            val tempInstance = INSTANCE
            tempInstance?.let {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DragonBallFamilyDatabase::class.java,
                    "dragon ball database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }

}