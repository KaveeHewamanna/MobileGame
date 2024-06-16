package com.example.cargame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RestartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restart)

        val restartBtn = findViewById<Button>(R.id.restart)
        restartBtn.setOnClickListener {
            // Navigate back to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Optional: Finish the RestartActivity to remove it from the back stack
        }
    }
}
