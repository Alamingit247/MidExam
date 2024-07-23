package com.example.no3_sharing

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonApp1: Button = findViewById(R.id.buttonApp1)
        val buttonApp2: Button = findViewById(R.id.buttonApp2)

        buttonApp1.setOnClickListener {
            val pm: PackageManager = packageManager
            val launchIntent: Intent? = pm.getLaunchIntentForPackage("com.example.calculatorapp")
            startActivity(launchIntent)
        }

        buttonApp2.setOnClickListener {
            val pm: PackageManager = packageManager
            val launchIntent: Intent? = pm.getLaunchIntentForPackage("com.example.colorfulapp")
            startActivity(launchIntent)
        }
    }
}