package com.example.a31c

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val retakeButton: Button = findViewById(R.id.retake_button)
        retakeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val finishButton: Button = findViewById(R.id.finish_button)
        finishButton.setOnClickListener {
            finish()
        }
    }
}
