package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val roll6SideButton: Button = findViewById(R.id.rollDice)
        roll6SideButton.setOnClickListener {
            //Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            val resultTextView: ImageView = findViewById(R.id.imageView)
            roll6SideButton.setOnClickListener {
                rollDice()
            }
        }

        val roll12SideButton: Button = findViewById(R.id.roll12Sided)
        roll12SideButton.setOnClickListener {
            val resultTextView: TextView = findViewById(R.id.textView2)
            roll12SideButton.setOnClickListener {
                roll12SidedDice()
            }
        }

        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Creates new Dice object with 6 sides and rolls it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find the ImageView in the layout

        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determines which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Updates the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Updates the content description
        diceImage.contentDescription = diceRoll.toString()
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