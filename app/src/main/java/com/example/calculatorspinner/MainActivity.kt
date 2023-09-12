package com.example.calculatorspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculatorspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.buttonCalculate.setOnClickListener {
            calculate()
        }
    }
    private fun calculate() {
        val number1str = binding.edittextNumber1.text.toString().trim()
        val number2str = binding.edittextNumber2.text.toString().trim()
        var error = false
        if (number1str.isEmpty()) {
            binding.edittextNumber1.error = "No number"
            error = true
        }
        if (number2str.isEmpty()) {
            binding.edittextNumber2.error = "No number"
            error = true
        }
        if (error) return

        val number1 = number1str.toDouble()
        val number2 = number2str.toDouble()
        var result = 0.0
        val operation: String = binding.spinnerOperations.selectedItem as String
        // https://www.geeksforgeeks.org/kotlin-when-expression/
        when (operation) {
            "+" -> result = number1 + number2
            "-" -> result = number1 - number2
            "*" -> result = number1 * number2
            "/" -> result = number1 / number2
        }
        val formattedResult = if (result % 1.0 == 0.0) {
            String.format("%d", result.toInt())
        } else {
            String.format("%.1f", result)
        }
        //val resultstr = result.toString()
        binding.textviewResult.text = formattedResult
    }
}