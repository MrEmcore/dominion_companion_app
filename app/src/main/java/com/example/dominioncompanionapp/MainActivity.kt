package com.example.dominioncompanionapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dominionAloneButton: Button = findViewById(R.id.dominion_alone)

        dominionAloneButton.setOnClickListener {
            val intent = Intent(this, DominionActivity::class.java)
            startActivity(intent)
        }
    }
}