package com.example.dominioncompanionapp

import android.media.MediaPlayer
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CardListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quick_game_card_list)

        // Find the parchment ImageView and the TextView for the cards
        val parchmentImage: ImageView = findViewById(R.id.parchment)
        val cardListTextView: TextView = findViewById(R.id.card_list)

        // Initially hide the TextView
        cardListTextView.visibility = TextView.INVISIBLE

        // Load the animation
        val unrollAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.unroll_animation)

        // Load the sound
        val mediaPlayer = MediaPlayer.create(this, R.raw.unrolling_parchment)

        // Set Animation Listener
        unrollAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                // Start playing the sound when the animation starts
                mediaPlayer.start()
            }

            override fun onAnimationEnd(animation: Animation?) {
                // Show the TextView after the animation ends
                cardListTextView.visibility = TextView.VISIBLE

                // Release the MediaPlayer to free up resources
                mediaPlayer.release()
            }

            override fun onAnimationRepeat(animation: Animation?) {
                // Not used
            }
        })

        // Start the animation on the parchment ImageView
        parchmentImage.startAnimation(unrollAnimation)

        // Retrieve the cards from the intent
        val cards = intent.getStringArrayListExtra("cards")

        // Display the cards in the TextView
        if (cards != null) {
            // Join the list of cards into a single string with line breaks
            cardListTextView.text = cards.joinToString("\n")
        } else {
            cardListTextView.text = "No cards available."
        }
    }
}