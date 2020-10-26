package com.wcc.lancedados2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val throwDiceButton = findViewById<Button>(R.id.btnThrowDice)

        val dice1Content = findViewById<ImageView>(R.id.dice1)
        val dice2Content = findViewById<ImageView>(R.id.dice2)

        val dicesImageList = listOf(R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3,
            R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6)

        // val resultText = findViewById<TextView>(R.id.resultText)

        throwDiceButton.setOnClickListener {
        dice1Content.setImageResource(throwDice(dicesImageList))
        dice2Content.setImageResource(throwDice(dicesImageList))
        }

       val playerName = intent.getStringExtra("playerName")
       val playerNameTextView = findViewById<TextView>(R.id.textViewPersonName)
       playerNameTextView.text = "Olá, $playerName!"
    }

    private fun throwDice(listOfDices: List<Int>): Int {
        val randomNum = (0..5).random()
        return listOfDices[randomNum]
    }
    // Other colleague solution
//    fun imagePicker(): Int {
//        return when((1..6).random()) {
//            1 -> R.drawable.dice_1
//            2 -> R.drawable.dice_2
//            3 -> R.drawable.dice_3
//            4 -> R.drawable.dice_4
//            5 -> R.drawable.dice_5
//            else -> R.drawable.dice_6
//        }
    }
