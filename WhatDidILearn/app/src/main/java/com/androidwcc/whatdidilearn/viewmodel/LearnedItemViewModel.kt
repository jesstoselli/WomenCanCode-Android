package com.androidwcc.whatdidilearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidwcc.whatdidilearn.data.LearnedItemDao
import com.androidwcc.whatdidilearn.entities.LearnedItem
import com.androidwcc.whatdidilearn.entities.UnderstandingLevel
import com.androidwcc.whatdidilearn.repository.LearnedItemsRepository
import kotlinx.coroutines.launch

class LearnedItemViewModel(private val repository: LearnedItemsRepository): ViewModel() {
    val learnedItemsList: LiveData<MutableList<LearnedItem>>

    init {
        learnedItemsList = repository.learnedItems
    }

    fun deleteLearnedItem(item: LearnedItem) {
        viewModelScope.launch {
            repository.deleteLearnedItem(item)
        }
    }
}