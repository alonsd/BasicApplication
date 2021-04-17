package com.basicapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.basicapplication.utils.constants.Database.BASIC_APPLICATION_TABLE


@Entity(tableName = BASIC_APPLICATION_TABLE)
data class BasicApplicationModel(@PrimaryKey val name : String)