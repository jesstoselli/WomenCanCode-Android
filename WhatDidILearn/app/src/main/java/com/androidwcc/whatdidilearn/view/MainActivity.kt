package com.androidwcc.whatdidilearn.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.androidwcc.whatdidilearn.R
import com.androidwcc.whatdidilearn.data.DatabaseItems
import com.androidwcc.whatdidilearn.databinding.ActivityMainBinding

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

        val learnedItemsList = DatabaseItems.getAll()
        adapter.data = learnedItemsList

    }
}