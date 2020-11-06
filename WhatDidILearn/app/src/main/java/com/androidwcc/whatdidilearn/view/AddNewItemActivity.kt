package com.androidwcc.whatdidilearn.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.androidwcc.whatdidilearn.R
import com.androidwcc.whatdidilearn.data.DatabaseItems
import com.androidwcc.whatdidilearn.databinding.ActivityAddNewItemBinding
import com.androidwcc.whatdidilearn.databinding.ActivityMainBinding
import com.androidwcc.whatdidilearn.repository.LearnedItemsRepository
import com.androidwcc.whatdidilearn.viewmodel.LearnedItemViewModel
import com.androidwcc.whatdidilearn.viewmodel.LearnedItemViewModelFactory
import com.androidwcc.whatdidilearn.viewmodel.NewLearnedItemViewModel
import com.androidwcc.whatdidilearn.viewmodel.NewLearnedItemViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class AddNewItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            ActivityAddNewItemBinding.inflate(
                layoutInflater
            )
        setContentView(binding.root)

        supportActionBar?.title =
            "New Learned Item"

        val database = DatabaseItems.getDatabase(
            this,
            CoroutineScope(Dispatchers.IO)
        )
        val dao = database.learnedItemDao()
        val repository = LearnedItemsRepository(dao)
        val viewModelFactory =
            NewLearnedItemViewModelFactory(repository)
        val viewModel = ViewModelProvider(
            this,
            viewModelFactory
        ).get(
            NewLearnedItemViewModel::class.java
        )


        binding.buttonSave.setOnClickListener {
            val title =
                binding.editTextTitle.text.toString()
            val description =
                binding.editTextDescription.text.toString()
            viewModel.insertNewLearnedItem(
                title,
                description
            )

            navigateToMainActivity()

        }

    }

    private fun navigateToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}