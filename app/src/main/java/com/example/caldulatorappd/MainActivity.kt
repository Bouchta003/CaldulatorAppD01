package com.example.caldulatorappd

import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import android.os.Bundle
import android.util.TypedValue
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

        val buttonAC = findViewById<Button>(R.id.buttonAC)
        buttonAC.setTextColor(0xFF858585.toInt())

        for (button in buttons) {
            button.setOnClickListener {
                if (button.id == R.id.buttonAC) {
                    stepsTxt.text = stringBuilder.toString()
                    stringBuilder.clear()
                    outputTxt.text =""}
                else
                    if (button.id == R.id.buttonBCK) {
                        if (stringBuilder.isNotEmpty()) {
                            stringBuilder.deleteCharAt(stringBuilder.length - 1)
                        }
                        outputTxt.text = stringBuilder.toString()
                    }
                    else
                        if (button.id == R.id.buttonEQUAL) {
                            val expression = stringBuilder.toString()

                            try {
                                val result = evaluateExpression(expression)
                                stepsTxt.text = expression
                                stringBuilder.clear()
                                outputTxt.text = "= $result"
                            } catch (e: Exception) {
                                outputTxt.text = "Error"
                            }
                        } else {
                            val buttonText = button.text.toString().substringAfter("button")
                            stringBuilder.append(buttonText)
                            outputTxt.text = stringBuilder.toString()
                        }
            }
        }

    }private fun evaluateExpression(expression: String): String {
        val tokens = transformToExpression(expression)
        val result = calculate(tokens)
        return result.toString()
    }
    private fun transformToExpression(expression: String): List<String> {
        val vals = mutableListOf<String>()
        var currentExp = ""
        for (char in expression) {
            if (char.isDigit() || char == '.') {
                currentExp += char
            } else {
                if (currentExp.isNotEmpty()) {
                    vals.add(currentExp)
                    currentExp = ""
                }
                vals.add(char.toString())
            }
        }
        if (currentExp.isNotEmpty()) {
            vals.add(currentExp)
        }
        return vals
    }
    private fun calculate(tokens: List<String>): Double {
        val stack = mutableListOf<Double>()
        var currentOperator = '+'
        for (token in tokens) {
            when {
                token == "+" || token == "-" || token == "*" || token == "/" -> {
                    currentOperator = token[0]
                }
                else -> {
                    val number = token.toDouble()
                    when (currentOperator) {
                        '+' -> stack.add(number)
                        '-' -> stack.add(-number)
                        '*' -> stack[stack.size - 1] *= number
                        '/' -> stack[stack.size - 1] /= number
                    }
                }
            }
        }
        return stack.sum()
    }
}