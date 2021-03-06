package com.androidwcc.whatdidilearn.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidwcc.whatdidilearn.data.LearnedItemDao
import com.androidwcc.whatdidilearn.repository.LearnedItemsRepository

class LearnedItemViewModelFactory(private val repository: LearnedItemsRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LearnedItemViewModel::class.java)) {
            return LearnedItemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}
