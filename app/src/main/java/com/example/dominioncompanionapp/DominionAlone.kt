package com.example.dominioncompanionapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DominionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dominion_alone)

        val randomizeButton: Button = findViewById(R.id.dominion_alone_randomizer)
        val recommendedSetsButton: Button = findViewById(R.id.recommended_sets)

        randomizeButton.setOnClickListener {
            val intent = Intent(this, CardListActivity::class.java)
            startActivity(intent)
        }

        recommendedSetsButton.setOnClickListener {
            val intent = Intent(this, RecommendedSetsActivity::class.java)
            startActivity(intent)
        }
    }
}
