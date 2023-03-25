package com.example.foodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodNames = resources.getStringArray(R.array.food_names)
        val foodDescriptions = resources.getStringArray(R.array.food_descriptions)
        val foodImages = resources.obtainTypedArray(R.array.food_images)

        val foods = ArrayList<Food>()
        for (i in foodNames.indices) {
            val food = Food(foodNames[i], foodDescriptions[i], foodImages.getResourceId(i, -1))
            foods.add(food)
        }

        val adapter = FoodAdapter(this, foods)
        val layoutManager = LinearLayoutManager(this)
        food_recycler_view.adapter = adapter
        food_recycler_view.layoutManager = layoutManager

        user_info_button.setOnClickListener {
            // Action for user info button
        }
    }
}

class Food(val name: String, val description: String, val imageResId: Int)

class FoodAdapter(private val context: Context, private val foods: ArrayList<Food>) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodImage: ImageView = itemView.findViewById(R.id.food_image)
        val foodName: TextView = itemView.findViewById(R.id.food_name)
        val foodDescription: TextView = itemView.findViewById(R.id.food_description)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val intent = Intent(context, food_detail::class.java)
                    intent.putExtra("food", foods[position])
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_food, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentFood = foods[position]
        holder.foodImage.setImageResource(currentFood.imageResId)
        holder.foodName.text = currentFood.name
        holder.foodDescription.text = currentFood.description
    }

    override fun getItemCount() = foods.size
}
