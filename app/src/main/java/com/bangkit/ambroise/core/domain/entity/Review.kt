package com.bangkit.ambroise.core.domain.entity

data class Review(
    val name: String,
    val date: String,
    val rating: Float,
    val imageUrl: String,
    val review: String,
)
