package com.basicapplication.model.models

data class BasicApplicationModel(
    val numbers: List<Number>
) {
    data class Number(
        val number: Int
    )
}