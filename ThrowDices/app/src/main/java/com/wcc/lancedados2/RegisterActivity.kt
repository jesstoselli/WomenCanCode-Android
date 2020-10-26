package com.wcc.lancedados2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val playButton = findViewById<Button>(R.id.btnPlay)

        val playerNameFromInput = findViewById<EditText>(R.id.editTextPersonName).text

        playButton.setOnClickListener {
            // Toast.makeText(this, "Name: $playerNameFromInput", Toast.LENGTH_LONG).show()


            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("playerName", "$playerNameFromInput")

            startActivity(intent)
        }
    }
}