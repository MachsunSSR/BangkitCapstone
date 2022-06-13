package com.bangkit.ambroise.core.domain.entity

data class Barber(
    val name: String,
    val imageUrl: String,
    val rating: Float,
    val address: String,
    val distance: Float,
)