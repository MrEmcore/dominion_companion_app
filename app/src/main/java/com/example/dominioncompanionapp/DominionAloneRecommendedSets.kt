package com.example.dominioncompanionapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class RecommendedSetsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dominion_alone_recommended_sets)

        val sets = listOf("Set 1", "Set 2", "Set 3", "Set 4")

        val listView: ListView = findViewById(R.id.sets_list)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, sets)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedSet = sets[position]
            val intent = Intent(this, CardListActivity::class.java)
            intent.putExtra("selected_set", selectedSet)
            startActivity(intent)
        }
    }
}
