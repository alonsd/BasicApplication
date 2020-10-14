package com.basicapplication.utils.network

import com.basicapplication.utils.Constants.NetworkErrorValues.ERROR401
import com.basicapplication.utils.Constants.NetworkErrorValues.ERROR404
import com.basicapplication.utils.Constants.NetworkErrorValues.GENERAL_ERROR
import retrofit2.HttpException


/**
 * Wrapper class to handle raw data when using REST API with Retrofit and Coroutines
 * and convert it to Resource class that handles potential errors.
 */
open class ResponseHandler {
    fun <T : Any> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T : Any> handleException(e: Exception): Resource<T> {
        return when (e) {
            is HttpException -> Resource.error(getErrorMessage(e.code()), null)
            else -> Resource.error(getErrorMessage(Int.MAX_VALUE), null)
        }
    }

    private fun getErrorMessage(code: Int): String {
        return when (code) {
            401 -> ERROR401
            404 -> ERROR404
            else -> GENERAL_ERROR
        }
    }


    /**
     * Wrapper class that enables error / loading / success handling.
     */
    data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
        companion object {
            fun <T> success(data: T?): Resource<T> {
                return Resource(Status.SUCCESS, data, null)
            }

            fun <T> error(message: String, data: T?): Resource<T> {
                return Resource(Status.ERROR, data, message)
            }

            fun <T> loading(data: T?): Resource<T> {
                return Resource(Status.LOADING, data, null)
            }
        }

        enum class Status {
            SUCCESS,
            ERROR,
            LOADING
        }
    }
}