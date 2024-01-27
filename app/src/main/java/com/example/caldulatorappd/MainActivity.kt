package com.example.caldulatorappd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonU = findViewById<Button>(R.id.buttonU)
        val buttonE = findViewById<Button>(R.id.buttonE)
        val resultTxt = findViewById<TextView>(R.id.outputTxt)

        val buttons = listOf(buttonU, buttonE /* Add more buttons to the list */)

        for (button in buttons) {
            button.setOnClickListener {
                resultTxt.text = button.text
            }
        }
    }
}