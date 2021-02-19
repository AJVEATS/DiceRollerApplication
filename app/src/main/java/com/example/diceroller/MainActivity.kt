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

        /*val roll12SideButton: Button = findViewById(R.id.roll12Sided)
        roll12SideButton.setOnClickListener {
            val resultTextView: TextView = findViewById(R.id.textView2)
            roll12SideButton.setOnClickListener {
                roll12SidedDice()
            }
        }
        */
        rollDice()
        roll12SideDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Creates a new Dice object with 6 sides and rolls it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Finds the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determines which drawable resource ID to used based on the dice roll
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

    private fun roll12SideDice() {
        // Creates a new Dice object with 12 sides and rolls it
        val dice2 = Dice(12)
        val diceRoll = dice2.roll()

        // As sides is larger than 6 the roll needs to be split between 2 die
        var die1 = 0
        var die2 = 0

        // Checks if the roll value is more than 6 to split between the 2 die
        if (diceRoll > 6) {
            die1 = 6
            die2 = (diceRoll - 6)

        } else {
            if(diceRoll == 1) {
                die1 = diceRoll
                die2 = 0
            }
            die1 = (diceRoll - 1)
            die2 = 1
        }

        // Finds the ImageView in the layout
        val diceImage1: ImageView = findViewById(R.id.imageView21)
        val diceImage2: ImageView = findViewById(R.id.imageView22)

        //Determines which drawable resource ID to be used based on the dice roll
        val drawableResource1 = when (die1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (die2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Updates the ImageView with the correct drawable resource ID
        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource((drawableResource2))

        // Updates the content description
        diceImage1.contentDescription = diceRoll.toString()
    }

    /*private fun roll12SidedDice() {
        // Creates a new Dice object with 12 sides and rolls it
        val dice2 = Dice(12)
        val diceRoll2 = dice2.roll()

        //Updates the screen with the dice roll of the 12 sided dice
        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text = diceRoll2.toString()
    }*/
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}