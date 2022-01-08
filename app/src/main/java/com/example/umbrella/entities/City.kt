package com.example.umbrella.entities

import java.time.ZoneOffset

data class City(val name: String,
                val longitude: Double,
                val latitude: Double,
                val timeZoneOffset: Int) { //Todo: Find a good way to convert these timezones.

    /*Todo: this might be replaced with a room dao auto converter or done in repository. Most likely option
    *  is to replace this with its own dao in room package.*/
    companion object {
        fun toCity(longitude: Double, latitude: Double): City {
            //Todo replace this sample data with real converter.
            return City("Vancouver", -123.12, 49.25, -8)
        }
    }
}
