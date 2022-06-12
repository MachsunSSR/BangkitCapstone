package com.bangkit.ambroise.util

import com.bangkit.ambroise.core.domain.entity.Facility

object Mapper {
    fun stringToFacilities(from: List<String>): List<Facility> {
        val to = ArrayList<Facility>()
        from.map {
            to.add(Facility(it))
        }

        return to.toList()
    }
}