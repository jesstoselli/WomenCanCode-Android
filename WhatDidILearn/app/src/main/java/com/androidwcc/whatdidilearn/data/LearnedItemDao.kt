package com.androidwcc.whatdidilearn.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.androidwcc.whatdidilearn.entities.LearnedItem

@Dao
interface LearnedItemDao {

    @Query("SELECT * FROM learned_item ORDER BY item_title ASC")
    fun getAll(): LiveData<List<LearnedItem>>

    @Insert
    suspend fun insert(item: LearnedItem)
}