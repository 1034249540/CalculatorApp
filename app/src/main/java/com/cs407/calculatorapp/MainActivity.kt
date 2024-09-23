package com.cs407.calculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById<EditText>(R.id.editTextNumber1)
        val num2 = findViewById<EditText>(R.id.editTextNumber2)

        val addButton = findViewById<Button>(R.id.buttonAdd)
        val subtractButton = findViewById<Button>(R.id.buttonSubtract)
        val multiplyButton = findViewById<Button>(R.id.buttonMultiply)
        val divideButton = findViewById<Button>(R.id.buttonDivide)

        addButton.setOnClickListener {
            calculate(num1, num2, "add")
        }

        subtractButton.setOnClickListener {
            calculate(num1, num2, "subtract")
        }

        multiplyButton.setOnClickListener {
            calculate(num1, num2, "multiply")
        }

        divideButton.setOnClickListener {
            if (num2.text.toString() == "0") {
                Toast.makeText(this, "Cannot divide by zero!", Toast.LENGTH_SHORT).show()
            } else {
                calculate(num1, num2, "divide")
            }
        }
    }

    private fun calculate(num1: EditText, num2: EditText, operation: String) {
        val number1 = num1.text.toString().toInt()
        val number2 = num2.text.toString().toInt()
        var result = 0

        when (operation) {
            "add" -> result = number1 + number2
            "subtract" -> result = number1 - number2
            "multiply" -> result = number1 * number2
            "divide" -> result = number1 / number2
        }

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("EXTRA_RESULT", result.toString())
        startActivity(intent)
    }
}
