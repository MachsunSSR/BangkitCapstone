package com.bangkit.ambroise.util

import com.bangkit.ambroise.core.domain.entity.GuestCalendar
import java.util.Calendar

object DateHelper {

    fun getListNextWeek(): List<GuestCalendar> {
        val c = Calendar.getInstance()

        val result = ArrayList<GuestCalendar>()
        for (i in 1..7) {
            c.add(Calendar.DAY_OF_WEEK, 1)
            result.add(
                GuestCalendar(
                    date = c.get(Calendar.DAY_OF_MONTH).toString(),
                    day = c.get(Calendar.DAY_OF_WEEK).toString().toDayName()
                )
            )
        }


        return result
    }
}