package com.androidstudies.colormyviews

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

        var currentColor = R.color.grey
        var boxOneColor = R.color.grey

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val sharedPreferences = this.getSharedPreferences("colors", Context.MODE_PRIVATE)
         val valueBoxOne = sharedPreferences.getInt("boxOneColor", R.color.grey)
         box_one_text.setBackgroundResource(valueBoxOne)

         setColorButtonsAction()
         colorBoxesThroughCode()

    }

    override fun onDestroy() {
        super.onDestroy()

//         save boxes' colors on sharedPreferences
       val sharedPreferences = this.getSharedPreferences("colors", Context.MODE_PRIVATE)
       val sharedPreferencesEditor = sharedPreferences.edit()

          sharedPreferencesEditor.putInt("boxOneColor", boxOneColor)

          sharedPreferencesEditor.commit()

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

        private fun colorBoxesThroughCode() {
        box_one_text.setOnClickListener {
            it.setBackgroundResource(currentColor)
            boxOneColor = currentColor
        }

        box_two_text.setOnClickListener {
            it.setBackgroundResource(currentColor)
        }

        box_three_text.setOnClickListener {
            it.setBackgroundResource(currentColor)
        }

        box_four_text.setOnClickListener {
            it.setBackgroundResource(currentColor)
        }

        box_five_text.setOnClickListener {
            it.setBackgroundResource(currentColor)
        }
    }
}