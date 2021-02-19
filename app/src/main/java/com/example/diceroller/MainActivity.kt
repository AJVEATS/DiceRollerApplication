package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val roll6SideButton: Button = findViewById(R.id.roll6Sided)
        roll6SideButton.setOnClickListener {
            //Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            val resultTextView: TextView = findViewById(R.id.textView)
            roll6SideButton.setOnClickListener {
                roll6SidedDice()
            }
        }

        val roll12SideButton: Button = findViewById(R.id.roll12Sided)
        roll12SideButton.setOnClickListener {
            val resultTextView: TextView = findViewById(R.id.textView2)
            roll12SideButton.setOnClickListener {
                roll12SidedDice()
            }
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun roll6SidedDice() {
        // Creates new Dice object with 6 sides and rolls it
        val dice1 = Dice(6)
        val diceRoll1 = dice1.roll()

        // Updates the screen with the dice roll of the 6 sided dice
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll1.toString()
    }

    private fun roll12SidedDice() {
        // Creates a new Dice object with 12 sides and rolls it
        val dice2 = Dice(12)
        val diceRoll2 = dice2.roll()

        //Updates the screen with the dice roll of the 12 sided dice
        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text = diceRoll2.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}