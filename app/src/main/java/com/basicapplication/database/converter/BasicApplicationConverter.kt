package com.basicapplication.database.converter

import androidx.room.TypeConverter
import com.basicapplication.model.BasicApplicationModel

class BasicApplicationConverter {

    @TypeConverter
    fun basicApplicationModelToString(model: BasicApplicationModel): String {
        return model.name
    }

    @TypeConverter
    fun stringToBasicApplicationModel(string: String): BasicApplicationModel {
        return BasicApplicationModel(string)
    }
}