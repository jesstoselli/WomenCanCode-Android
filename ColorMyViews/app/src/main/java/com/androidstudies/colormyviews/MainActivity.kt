package com.androidstudies.colormyviews

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

        var currentColor = R.color.grey
        var boxOneColor = R.color.grey
        var boxTwoColor = R.color.grey
        var boxThreeColor = R.color.grey
        var boxFourColor = R.color.grey
        var boxFiveColor = R.color.grey

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val sharedPreferences = this.getSharedPreferences("colors", Context.MODE_PRIVATE)
         val valueBoxOne = sharedPreferences.getInt("boxOneColor", R.color.grey)
         val valueBoxTwo = sharedPreferences.getInt("boxTwoColor", R.color.grey)
         val valueBoxThree = sharedPreferences.getInt("boxThreeColor", R.color.grey)
         val valueBoxFour = sharedPreferences.getInt("boxFourColor", R.color.grey)
         val valueBoxFive = sharedPreferences.getInt("boxFiveColor", R.color.grey)


         box_one_text.setBackgroundResource(valueBoxOne)
         box_two_text.setBackgroundResource(valueBoxTwo)
         box_three_text.setBackgroundResource(valueBoxThree)
         box_four_text.setBackgroundResource(valueBoxFour)
         box_five_text.setBackgroundResource(valueBoxFive)

         setColorButtonsAction()
         colorBoxesThroughCode()

    }

    override fun onStop() {
        super.onStop()

        // save boxes' colors on sharedPreferences
        val sharedPreferences = this.getSharedPreferences("colors", Context.MODE_PRIVATE)
        val sharedPreferencesEditor = sharedPreferences.edit()

        sharedPreferencesEditor.putInt("boxOneColor", boxOneColor)
        sharedPreferencesEditor.putInt("boxTwoColor", boxTwoColor)
        sharedPreferencesEditor.putInt("boxThreeColor", boxThreeColor)
        sharedPreferencesEditor.putInt("boxFourColor", boxFourColor)
        sharedPreferencesEditor.putInt("boxFiveColor", boxFiveColor)

        sharedPreferencesEditor.apply()
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