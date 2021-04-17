package com.basicapplication.utils.data


/**
 * Wrapper class to handle raw data when using REST API with Retrofit and Coroutines
 * and convert it to Resource class that handles potential errors.
 */
sealed class Resource<T> {

    abstract val data: T?

    data class Success<T>(override val data: T) : Resource<T>()

    data class Exception<T>(val throwable: Throwable, override val data: T? = null) : Resource<T>()
}