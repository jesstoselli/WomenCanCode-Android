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
            R.color.purple_700 -> UnderstandingLevel.LOW
            R.color.purple_500 -> UnderstandingLevel.MEDIUM
            else -> UnderstandingLevel.HIGH
        }

    }

}