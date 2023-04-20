package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

@Suppress("CAST_NEVER_SUCCEEDS")
class food_detail : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_food_detail)

            val food = intent.getSerializableExtra("food") as Food

            val foodImageDetail: ImageView = findViewById(R.id.food_detail_image)
            val foodNameDetail: TextView = findViewById(R.id.food_detail_name)
            val foodDescriptionDetail: TextView = findViewById(R.id.food_detail_description)

            foodImageDetail.setImageResource(food.imageResId)
            foodNameDetail.text = food.name
            foodDescriptionDetail.text = food.description
        }
    }