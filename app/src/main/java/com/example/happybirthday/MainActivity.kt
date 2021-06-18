package com.example.happybirthday

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        rollDice()
    }


    private fun rollDice() {
        //create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView2)

        //determine which drawable resource ID to use based on the dice roll
        when (diceRoll){
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
        //update content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val sides: Int){
    //function to get random dice roll and return result
    fun roll(): Int {
        return(1..sides).random()
    }
}