package com.androidwcc.whatdidilearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.androidwcc.whatdidilearn.data.LearnedItemDao
import com.androidwcc.whatdidilearn.entities.LearnedItem

class LearnedItemViewModel(private val dao: LearnedItemDao): ViewModel() {
    val learnedItemsList: LiveData<List<LearnedItem>>

    init {
        learnedItemsList = dao.getAll()
    }
}