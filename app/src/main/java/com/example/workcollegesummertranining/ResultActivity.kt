package com.example.workcollegesummertranining

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Extract the user score and username from the intent extras
        val userScore = intent.getIntExtra("USER_SCORE", 0)
        val username = intent.getStringExtra("USERNAME") ?: ""

        // Find the views in the layout
        val tvScore = findViewById<TextView>(R.id.tv_score)
        val tvName = findViewById<TextView>(R.id.tv_name)
        val btnFinish = findViewById<Button>(R.id.btn_finish)
        tvScore.text = "Your Score: is $userScore out of 10 "
        tvName.text = username
        val tvCongratulations = findViewById<TextView>(R.id.tv_congratulations)

        when (userScore) {
            in 0..5 -> {
                tvCongratulations.text = "We need to practice more"
            }
            in 6..8 -> {
                tvCongratulations.text = "Not Bad"
            }
            in 9..10 -> {
                tvCongratulations.text = "Hey, Congratulations!"
            }
            else -> {
                tvCongratulations.text = ""
            }
        }

        // Set the click listener for the FINISH button
        btnFinish.setOnClickListener {
            // Create an intent to navigate back to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Close the current activity (ResultActivity)
        }
    }
}
