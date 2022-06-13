package com.bangkit.ambroise.core.domain.entity

data class GuestCalendar(
    val date: String,
    val day: String,
    var isSelected: Boolean = false,
)
