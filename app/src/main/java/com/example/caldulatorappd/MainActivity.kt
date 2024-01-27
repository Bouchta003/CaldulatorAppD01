package com.example.caldulatorappd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val stringBuilder = StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val stepsTxt = findViewById<TextView>(R.id.stepsTxt)
        val outputTxt = findViewById<TextView>(R.id.outputTxt)
        val buttons = listOf(
            findViewById<Button>(R.id.buttonE),
            findViewById<Button>(R.id.buttonU),
            findViewById<Button>(R.id.buttonSIN),
            findViewById<Button>(R.id.buttonDEG),
            findViewById<Button>(R.id.buttonAC),
            findViewById<Button>(R.id.buttonBCK),
            findViewById<Button>(R.id.buttonDIV),
            findViewById<Button>(R.id.buttonX),
            findViewById<Button>(R.id.button7),
            findViewById<Button>(R.id.button8),
            findViewById<Button>(R.id.button9),
            findViewById<Button>(R.id.buttonMINUS),
            findViewById<Button>(R.id.button4),
            findViewById<Button>(R.id.button5),
            findViewById<Button>(R.id.button6),
            findViewById<Button>(R.id.button1),
            findViewById<Button>(R.id.button2),
            findViewById<Button>(R.id.button3),
            findViewById<Button>(R.id.button0),
            findViewById<Button>(R.id.buttonPOINT),
            findViewById<Button>(R.id.buttonPLUS),
            findViewById<Button>(R.id.buttonEQUAL)
        )
        val textColor = resources.getColor(R.color.my_text_color, null)

        for (button in buttons) {
            button.setTextColor(textColor)
        }
        for (button in buttons) {
            button.setOnClickListener {
                if (button.id == R.id.buttonEQUAL) {
                    stepsTxt.text = stringBuilder.toString()
                    stringBuilder.clear()
                    outputTxt.text =""
                } else {
                    val buttonText = button.text.toString().substringAfter("button")
                    stringBuilder.append(buttonText)
                    outputTxt.text = stringBuilder.toString()
                }
            }
        }
    }
}