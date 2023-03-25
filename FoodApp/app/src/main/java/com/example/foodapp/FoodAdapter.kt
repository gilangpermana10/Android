package com.example.foodapp

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(val foodList: MainActivity, val clickListener: FoodClickListener) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodImage: ImageView = itemView.findViewById(R.id.food_image)
        val foodName: TextView = itemView.findViewById(R.id.food_name)
        val foodDescription: TextView = itemView.findViewById(R.id.food_description)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
    val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_food, parent, false)
    return FoodViewHolder(itemView)
}

override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
    val currentFood = foodList[position]
    holder.foodImage.setImageResource(currentFood.imageResId)
    holder.foodName.text = currentFood.name
    holder.foodDescription.text = currentFood.description

    holder.itemView.setOnClickListener {
        clickListener.onFoodClick(currentFood)
    }
}

override fun getItemCount() = foodList.size

}

class FoodClickListener {

}
