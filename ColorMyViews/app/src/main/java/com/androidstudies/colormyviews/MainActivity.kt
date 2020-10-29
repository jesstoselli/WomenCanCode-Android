package com.androidstudies.colormyviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

        var currentColor = R.color.grey

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setColorButtonsAction()
    }

        private fun setColorButtonsAction() {

            btn_red.setOnClickListener {
                currentColor = R.color.red
            }

            btn_yellow.setOnClickListener {
                currentColor = R.color.yellow
            }

            btn_green.setOnClickListener {
                currentColor = R.color.green
            }

        }

}