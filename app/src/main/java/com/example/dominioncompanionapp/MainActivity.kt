package com.example.dominioncompanionapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val randomizeButton: Button = findViewById(R.id.quick_play)

        randomizeButton.setOnClickListener {
            // Generate randomized cards
            val cards = randomize()

            // Create an intent to navigate to CardListActivity
            val intent = Intent(this, CardListActivity::class.java)
            // Pass the cards to the new activity
            intent.putStringArrayListExtra("cards", ArrayList(cards))
            startActivity(intent)
        }
    }

    private fun randomize(): Set<String> {
        val dominionCards = listOf(
            "Artisan", "Bandit", "Bureaucrat", "Cellar", "Chapel", "Council Room", "Festival", "Gardens",
            "Harbinger", "Laboratory", "Library", "Market", "Merchant", "Militia", "Mine", "Moat",
            "Moneylender", "Poacher", "Remodel", "Sentry", "Smithy", "Throne Room", "Vassal", "Village",
            "Witch", "Workshop"
        )
        val gameCards = mutableSetOf<String>()

        while (gameCards.size < 10) {
            val card = dominionCards.random()
            gameCards.add(card)
        }

        return gameCards
    }
}