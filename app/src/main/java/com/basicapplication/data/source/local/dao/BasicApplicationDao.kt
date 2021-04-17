package com.basicapplication.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.basicapplication.model.BasicApplicationModel
import com.basicapplication.utils.constants.Database.BASIC_APPLICATION_TABLE


@Dao
interface BasicApplicationDao {

    @Query("select * from $BASIC_APPLICATION_TABLE")
    suspend fun getBasicApplicationModel() : BasicApplicationModel
}