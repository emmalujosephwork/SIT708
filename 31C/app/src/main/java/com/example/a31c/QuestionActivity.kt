package com.example.a31c

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionActivity : AppCompatActivity() {

    private var currentQuestionIndex = 0
    private var score = 0
    private val correctAnswers = arrayOf("A", "C", "B") // Example answers
    private val progressBar: ProgressBar by lazy { findViewById(R.id.progress_bar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val submitButton: Button = findViewById(R.id.submit_button)
        val nextButton: Button = findViewById(R.id.next_button)

        loadQuestion(currentQuestionIndex)

        submitButton.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            val selectedRadioButton: RadioButton = findViewById(selectedRadioButtonId)

            if (selectedRadioButton.text.toString() == correctAnswers[currentQuestionIndex]) {
                score++
                selectedRadioButton.setBackgroundColor(resources.getColor(R.color.green))
            } else {
                selectedRadioButton.setBackgroundColor(resources.getColor(R.color.red))
            }
        }

        nextButton.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < correctAnswers.size) {
                loadQuestion(currentQuestionIndex)
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("SCORE", score)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun loadQuestion(index: Int) {
        // Load the question and choices dynamically, e.g.:
        val questionText = "Question $index"
        val choices = arrayOf("A", "B", "C", "D")

        // Update UI with the question and choices
        // Example: Update your UI components to show the question text and options
    }
}
