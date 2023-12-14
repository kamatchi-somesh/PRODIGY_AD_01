package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // Variable to store the current operand
    private var currentOperand: Double = 0.0
    // Variable to store the current operator
    private var currentOperator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set click listeners for number buttons
        btn0.setOnClickListener { numberClick("0") }
        btn1.setOnClickListener { numberClick("1") }
        btn2.setOnClickListener { numberClick("2") }
        btn3.setOnClickListener { numberClick("3") }
        btn4.setOnClickListener { numberClick("4") }
        btn5.setOnClickListener { numberClick("5") }
        btn6.setOnClickListener { numberClick("6") }
        btn7.setOnClickListener { numberClick("7") }
        btn8.setOnClickListener { numberClick("8") }
        btn9.setOnClickListener { numberClick("9") }

        // Set click listeners for operator buttons
        btnPlus.setOnClickListener { operatorClick("+") }
        btnMinus.setOnClickListener { operatorClick("-") }
        btnMultiply.setOnClickListener { operatorClick("*") }
        btnDivide.setOnClickListener { operatorClick("/") }

        // Set click listener for equals button
        btnEquals.setOnClickListener { calculateResult() }

        // Set click listener for clear button
        btnClear.setOnClickListener { clearCalculator() }
    }

    // Function to handle number button clicks
    private fun numberClick(number: String) {
        val currentText = txtResult.text.toString()
        txtResult.text = currentText + number
    }

    // Function to handle operator button clicks
    private fun operatorClick(operator: String) {
        currentOperator = operator
        currentOperand = txtResult.text.toString().toDouble()
        txtResult.text = ""
    }

    // Function to calculate and display the result
    private fun calculateResult() {
        val operand2 = txtResult.text.toString().toDouble()
        var result = 0.0

        when (currentOperator) {
            "+" -> result = currentOperand + operand2
            "-" -> result = currentOperand - operand2
            "*" -> result = currentOperand * operand2
            "/" -> result = currentOperand / operand2
        }

        txtResult.text = result.toString()
    }

    // Function to clear the calculator
    private fun clearCalculator() {
        txtResult.text = ""
        currentOperand = 0.0
        currentOperator = ""
    }
}
