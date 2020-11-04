package com.androidwcc.whatdidilearn.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidwcc.whatdidilearn.R
import com.androidwcc.whatdidilearn.databinding.ActivityMainBinding

class AddNewItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        setContentView(R.layout.activity_add_new_item)
        supportActionBar?.title="New Learned Item"
    }
}