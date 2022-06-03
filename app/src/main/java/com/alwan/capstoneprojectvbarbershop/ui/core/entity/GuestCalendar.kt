package com.alwan.capstoneprojectvbarbershop.ui.core.entity

data class GuestCalendar(
    val date: String,
    val day: String,
    var isSelected: Boolean = false,
)
