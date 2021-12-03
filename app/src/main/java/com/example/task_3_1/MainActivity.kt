package com.example.task_3_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.text.isDigitsOnly
import com.google.android.material.textfield.TextInputLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCheckAnswer = findViewById<Button>(R.id.btnCheckAnswer)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val userInput = findViewById<TextInputLayout>(R.id.userInput)
        val resultText = findViewById<TextView>(R.id.resultText)

        var randomNumber = Random.nextInt(0, 1000)

        btnCheckAnswer.setOnClickListener {
            if (!userInput.editText?.text?.toString().isNullOrEmpty() && userInput.editText?.text?.toString()?.isDigitsOnly() == true){
                if (randomNumber != userInput.editText?.text?.toString()?.toInt()){
                    if (randomNumber > userInput.editText?.text?.toString()?.toInt()!!){
                        resultText.text = getString(R.string.wrongIsBigger)
                        resultText.setTextColor(Color.RED)
                    } else {
                        resultText.text = getString(R.string.wrongIsSmaller)
                        resultText.setTextColor(Color.RED)
                    }
                }
                else {
                    resultText.text = getString(R.string.correctAnswer)
                    resultText.setTextColor(Color.GREEN)
                    btnReset.visibility = Button.VISIBLE
                }
            }
            else resultText.text = getString(R.string.plsEnterANum)
        }

        btnReset.setOnClickListener {
            randomNumber = Random.nextInt(0, 1000)
            btnReset.visibility = Button.INVISIBLE
            userInput.editText?.text?.clear()
        }
    }
}