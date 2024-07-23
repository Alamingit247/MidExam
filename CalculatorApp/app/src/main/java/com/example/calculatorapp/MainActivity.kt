package com.example.calculatorapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatorapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val input1: EditText = findViewById(R.id.input1)
        val input2: EditText = findViewById(R.id.input2)
        val result: TextView = findViewById(R.id.result)
        val add: Button = findViewById(R.id.add)
        val sub: Button = findViewById(R.id.sub)
        val mul: Button = findViewById(R.id.mul)
        val div: Button = findViewById(R.id.div)

        add.setOnClickListener {
            calculate('+', input1, input2, result)
        }

        sub.setOnClickListener {
            calculate('-', input1, input2, result)
        }

        mul.setOnClickListener {
            calculate('*', input1, input2, result)
        }

        div.setOnClickListener {
            calculate('/', input1, input2, result)
        }
    }

    private fun calculate(operator: Char, input1: EditText, input2: EditText, result: TextView) {
        val x = input1.text.toString().toDoubleOrNull() ?: return
        val y = input2.text.toString().toDoubleOrNull() ?: return

        val output = when (operator) {
            '+' -> x + y
            '-' -> x - y
            '*' -> x * y
            '/' -> {
                if (y != 0.0)
                    x / y
                else {
                    "Cannot divide by zero!"
                }
            }
            else -> "Invalid operator"
        }

        result.text = output.toString()
    }
}
