package com.androidwcc.whatdidilearn.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidwcc.whatdidilearn.data.LearnedItemDao
import com.androidwcc.whatdidilearn.entities.LearnedItem
import com.androidwcc.whatdidilearn.entities.UnderstandingLevel
import com.androidwcc.whatdidilearn.repository.LearnedItemsRepository
import kotlinx.coroutines.launch

class NewLearnedItemViewModel(private var repository: LearnedItemsRepository): ViewModel() {

    fun insertNewLearnedItem(itemTitle: String, itemDescription: String) {
        viewModelScope.launch {
            val item = LearnedItem(itemTitle, itemDescription, UnderstandingLevel.HIGH)
            repository.insertNewLearnedItem(item)
        }
    }

}