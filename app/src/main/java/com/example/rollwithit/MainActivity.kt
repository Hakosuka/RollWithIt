package com.example.rollwithit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.Random

class MainActivity : AppCompatActivity() {

    /**lateinit promises the Kotlin compiler that this will be initialised before its called upon
     * Therefore it doesn't need to be nullable and clog up this code with null checks
     */
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Yeah, I know the UI should be implemented with Frags
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{
            rollDice()
        }
        diceImage = findViewById(R.id.dice_image) //findViewById calls are now independent of rollDice, yay
    }

    /**
     * Rolls the dice.
     */
    private fun rollDice() {
        //val randomInt = Random().nextInt(6) + 1
        val drawableRes = when(Random().nextInt(6) + 1){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableRes)
    }
}
