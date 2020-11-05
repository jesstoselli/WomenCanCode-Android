package com.androidwcc.whatdidilearn.data

import androidx.room.TypeConverter
import com.androidwcc.whatdidilearn.R
import com.androidwcc.whatdidilearn.entities.UnderstandingLevel

class Converters {

    @TypeConverter
    fun levelToInt(level: UnderstandingLevel): Int {
        return level.color
    }

    @TypeConverter
    fun intToLevel(color: Int): UnderstandingLevel {
        return when(color) {
            R.color.pistachio -> UnderstandingLevel.LOW
            R.color.zomp -> UnderstandingLevel.MEDIUM
            else -> UnderstandingLevel.HIGH
        }

    }

}