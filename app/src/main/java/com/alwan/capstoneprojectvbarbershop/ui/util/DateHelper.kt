package com.alwan.capstoneprojectvbarbershop.ui.util

import android.util.Log
import com.alwan.capstoneprojectvbarbershop.ui.core.entity.GuestCalendar
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

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