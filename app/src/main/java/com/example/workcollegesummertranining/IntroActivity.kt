package com.example.workcollegesummertranining

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView

class IntroActivity : AppCompatActivity() {

    private val images = arrayOf(R.drawable.screen1, R.drawable.screen2, R.drawable.screen3)
    private var currentImageIndex = 0
    private val delayMillis = 3000L // 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val imageView: ImageView = findViewById(R.id.imageView) // Replace with your ImageView's ID

        // Set an initial image
        imageView.setImageResource(images[currentImageIndex])

        // Schedule image changes with a delay
        val handler = Handler()
        val imageChangeRunnable = object : Runnable {
            override fun run() {
                currentImageIndex++
                if (currentImageIndex < images.size) {
                    imageView.setImageResource(images[currentImageIndex])
                    handler.postDelayed(this, delayMillis)
                } else {
                    // All images shown, start the main activity
                    val intent = Intent(this@IntroActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Finish the intro activity
                }
            }
        }

        // Start the image changing process
        handler.postDelayed(imageChangeRunnable, delayMillis)
    }
}
