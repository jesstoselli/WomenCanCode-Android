package com.androidwcc.whatdidilearn.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.androidwcc.whatdidilearn.entities.LearnedItem

@Dao
interface LearnedItemDAO {

    @Query("SELECT * FROM learned_item ORDER BY item_title ASC")
    fun getAll(): List<LearnedItem>

    @Insert
    fun insert(item: LearnedItem)
}