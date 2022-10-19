package com.cs473

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.cs473.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var foods = mutableListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("DinnerDecider")
        setFoodText(foods.get(Random.nextInt(0, foods.size-1)))

        binding.content.addFoodButton.setOnClickListener {
            if(binding.content.addFoodEditText.text.toString().isEmpty()){
               Toast.makeText(this, "Enter new food", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            foods.add(binding.content.addFoodEditText.text.toString())
            setFoodText(foods.get(Random.nextInt(0, foods.size-1)))
        }

        binding.content.decideButton.setOnClickListener {
            setFoodText(foods.get(Random.nextInt(0, foods.size-1)))
        }
    }

    private fun setFoodText(food: String){
        binding.content.foodTextView.setText(food)

    }

}