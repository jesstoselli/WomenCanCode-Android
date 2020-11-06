package com.androidwcc.whatdidilearn.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidwcc.whatdidilearn.data.LearnedItemDao
import com.androidwcc.whatdidilearn.repository.LearnedItemsRepository


class NewLearnedItemViewModelFactory (private val repository: LearnedItemsRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewLearnedItemViewModel::class.java)) {
            return NewLearnedItemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
