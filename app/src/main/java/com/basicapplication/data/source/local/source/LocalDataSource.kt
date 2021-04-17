package com.basicapplication.data.source.local.source

import com.basicapplication.data.source.local.dao.BasicApplicationDao
import com.basicapplication.model.BasicApplicationModel
import com.basicapplication.utils.extensions.wrapWithResource

class LocalDataSource(private val basicApplicationDao: BasicApplicationDao) {

    suspend fun getBasicApplicationModel() =  wrapWithResource<BasicApplicationModel>(basicApplicationDao.getBasicApplicationModel())

}