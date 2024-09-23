package com.cs407.calculatorapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        val result = intent.getStringExtra("EXTRA_RESULT")
        val resultTextView = findViewById<TextView>(R.id.textViewResult)
        resultTextView.text = "Result: $result"
    }
}