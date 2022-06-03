package com.alwan.capstoneprojectvbarbershop.ui.util

import com.alwan.capstoneprojectvbarbershop.ui.core.entity.Facility

object Mapper {
    fun stringToFacilities(from: List<String>): List<Facility> {
        val to = ArrayList<Facility>()
        from.map {
            to.add(Facility(it))
        }

        return to.toList()
    }
}