package com.bangkit.ambroise.core.domain.entity

data class Book (
    val date: String,
    val service: String,
    val guest: Int,
    val bill: Float,
    val additionalCost: Float,
)