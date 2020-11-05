package com.androidwcc.whatdidilearn.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.androidwcc.whatdidilearn.R
import com.androidwcc.whatdidilearn.data.DatabaseItems
import com.androidwcc.whatdidilearn.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_main)

        val recyclerView = binding.recyclerViewItemsLearned
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_items_learned)
        val adapter = LearnedItemsAdapter()
        recyclerView.adapter = adapter

        val database = DatabaseItems.getDatabase(this, CoroutineScope(Dispatchers.IO))
        val dao = database.learnedItemDao()
        val itemsList = dao.getAll()
        itemsList.observe(this, Observer { items ->
            adapter.data = items
        })

       binding.fabAddItem.setOnClickListener {
            val intent = Intent(this, AddNewItemActivity::class.java)
            startActivity(intent)
        }

    }
}