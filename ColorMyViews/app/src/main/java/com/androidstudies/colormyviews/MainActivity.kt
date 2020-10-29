package com.androidstudies.colormyviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

        var currentColor = R.color.grey

        fun colorBoxes(boxId: View) {
            boxId.setOnClickListener {
                boxId.setBackgroundResource(currentColor)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setColorButtonsAction()
        // colorBoxesThroughCode()

        box_one_text.setBackgroundResource(currentColor)
        box_two_text.setBackgroundResource(currentColor)
        box_three_text.setBackgroundResource(currentColor)
        box_four_text.setBackgroundResource(currentColor)
        box_five_text.setBackgroundResource(currentColor)

    }

    override fun onDestroy() {
        super.onDestroy()

        // salvar no sharedPreferences a cor das caixas
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