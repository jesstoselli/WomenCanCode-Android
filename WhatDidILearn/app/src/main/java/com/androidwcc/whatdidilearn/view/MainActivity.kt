package com.androidwcc.whatdidilearn.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.androidwcc.whatdidilearn.data.DatabaseItems
import com.androidwcc.whatdidilearn.databinding.ActivityMainBinding
import com.androidwcc.whatdidilearn.repository.LearnedItemsRepository
import com.androidwcc.whatdidilearn.viewmodel.LearnedItemViewModel
import com.androidwcc.whatdidilearn.viewmodel.LearnedItemViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(
            layoutInflater
        )
        setContentView(binding.root)

        val recyclerView = binding.recyclerViewItemsLearned
        val adapter = LearnedItemsAdapter()
        recyclerView.adapter = adapter


        val database = DatabaseItems.getDatabase(this, CoroutineScope(Dispatchers.IO))
        val dao = database.learnedItemDao()
        val repository = LearnedItemsRepository(dao)
        val viewModelFactory = LearnedItemViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(LearnedItemViewModel::class.java)
        val itemsList = viewModel.learnedItemsList
        itemsList.observe(this, Observer { items ->
                adapter.data = items
            })

        val itemTouchHelperCallback =
            object :
                ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT ) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    val itemToDelete = adapter.data[position]
                    adapter.deleteItem(itemToDelete)
                    viewModel.deleteLearnedItem(itemToDelete)

                }

            }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

       binding.fabAddItem.setOnClickListener {
            val intent = Intent(this, AddNewItemActivity::class.java)
            startActivity(intent)
        }


        val removedItemThroughButtonClickOnAdapter = adapter.getRemoveItemPosition()
        removedItemThroughButtonClickOnAdapter?.let {
            viewModel.deleteLearnedItem(
                it
            )
        }

    }

}

