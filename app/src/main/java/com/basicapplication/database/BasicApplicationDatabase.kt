package com.basicapplication.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.basicapplication.data.source.local.dao.BasicApplicationDao
import com.basicapplication.database.converter.BasicApplicationConverter
import com.basicapplication.model.BasicApplicationModel
import com.basicapplication.utils.application.App
import com.basicapplication.utils.constants.Database.BASIC_APPLICATION_DATABASE


@Database(entities = [BasicApplicationModel::class], version = 1, exportSchema = false)
@TypeConverters(BasicApplicationConverter::class)
abstract class BasicApplicationDatabase : RoomDatabase() {


    abstract fun basicApplicationDao () : BasicApplicationDao

    companion object {

        private var instance : BasicApplicationDatabase? = null

        @Synchronized
        fun getInstance(): BasicApplicationDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(App.applicationContext(), BasicApplicationDatabase::class.java, BASIC_APPLICATION_DATABASE)
                    .fallbackToDestructiveMigration().build()
            }
            return instance!!
        }
    }

}