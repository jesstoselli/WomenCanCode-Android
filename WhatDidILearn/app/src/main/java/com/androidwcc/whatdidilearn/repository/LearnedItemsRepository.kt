package com.androidwcc.whatdidilearn.repository

import com.androidwcc.whatdidilearn.data.LearnedItemDao
import com.androidwcc.whatdidilearn.entities.LearnedItem

class LearnedItemsRepository(private val dao: LearnedItemDao) {

    val learnedItems = dao.getAll()

    suspend fun insertNewLearnedItem(item: LearnedItem) {
        dao.insert(item)
    }

    suspend fun deleteLearnedItem(item: LearnedItem) {
        dao.delete(item)
    }

}