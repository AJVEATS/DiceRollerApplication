package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val roll6SideButton: Button = findViewById(R.id.rollDice)
        val roll12SideButton: Button = findViewById(R.id.roll12Sided)

        roll6SideButton.setOnClickListener {
            roll6SideButton.setOnClickListener {
                rollDice()
            }
        }

        roll12SideButton.setOnClickListener {
            roll12SideButton.setOnClickListener {
                roll12SidedDice()
            }
        }

        rollDice()
        roll12SidedDice()
    }

    // Roll the dice and update the screen with the result.
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

    private fun roll12SidedDice() {
        // Creates a new Dice object with 12 sides and rolls it
        val dice2 = Dice(12)
        val diceRoll = dice2.roll12()

        // As the amount of sides on the die is greater than 6 the dies' roll needs to be split between 2 die
        var diceRoll1: Int
        var diceRoll2: Int

        // Checks if the roll value is more than 6 to split between the 2 die
        if (diceRoll > 6) {
            diceRoll1 = 6
            diceRoll2 = (diceRoll - 6)
        } else {
            diceRoll1 = (diceRoll - 1)
            diceRoll2 = 1
        }

        // Finds the ImageView in the layout
        val diceImage1: ImageView = findViewById(R.id.imageView21)
        val diceImage2: ImageView = findViewById(R.id.imageView22)

        //Determines which drawable resource ID to be used based on the dice roll
        val drawableResource1 = when (diceRoll1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Updates the ImageView with the correct drawable resource ID
        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)

        // Updates the content description
        diceImage1.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }

    fun roll12(): Int {
        return (2..numSides).random()
    }
}