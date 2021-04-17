package com.basicapplication.data.source.remote.source

import com.basicapplication.data.source.remote.api.NetworkApi
import com.basicapplication.utils.data.Resource
import com.basicapplication.utils.extensions.wrapWithResource
import retrofit2.HttpException
import java.lang.Exception

class RemoteDataSource(private val networkApi: NetworkApi) {

    suspend fun getDataFromPath() = wrapWithResource<Any>(networkApi.getDataFromPath())


}