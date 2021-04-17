package com.basicapplication.utils.extensions

import com.basicapplication.utils.data.Resource

fun <T> wrapWithResource(data : Any): Resource<Any> {
    return try {
        Resource.Success(data)
    } catch (e: Exception) {
        Resource.Exception(e)
    }
}