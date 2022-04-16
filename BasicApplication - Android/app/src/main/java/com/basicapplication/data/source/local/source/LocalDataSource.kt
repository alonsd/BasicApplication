package com.basicapplication.data.source.local.source

import com.basicapplication.data.source.local.dao.BasicApplicationDao


class LocalDataSource(private val basicApplicationDao: BasicApplicationDao) {

    suspend fun getBasicApplicationModel() =  basicApplicationDao.getBasicApplicationModel()

}