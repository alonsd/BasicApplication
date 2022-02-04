package com.basicapplication.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.basicapplication.model.entities.BasicApplicationEntity
import com.basicapplication.utils.constants.Database.BASIC_APPLICATION_TABLE


@Dao
interface BasicApplicationDao {

    @Query("select * from BasicApplicationTable")
    suspend fun getBasicApplicationModel() : BasicApplicationEntity
}