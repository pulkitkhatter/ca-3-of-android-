package com.example.workcollegesummertranining

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText


class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var etName: AppCompatEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        val buttonStart: Button = findViewById(R.id.btn_start)
        etName = findViewById(R.id.et_name)

        // Retrieve the saved username
        val savedUsername = sharedPreferences.getString("USERNAME", "")
        etName.setText(savedUsername)

        buttonStart.setOnClickListener {
            val username = etName.text.toString().trim()
            if (username.isEmpty()) {
                Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show()
            } else {
                // Save the username to SharedPreferences
                val editor = sharedPreferences.edit()
                editor.putString("USERNAME", username)
                editor.apply()

                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
            }
        }
    }
}
