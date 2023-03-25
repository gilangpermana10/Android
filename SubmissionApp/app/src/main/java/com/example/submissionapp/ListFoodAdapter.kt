package com.example.submissionapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ListFoodsAdapter(val listFoods: ArrayList<Foods>) : RecyclerView.Adapter<ListFoodsAdapter.ListViewHolder>() {
    var onItemClick : ((Foods) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_foods, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val food = listFoods[position]
        holder.imgPhoto.setImageResource(food.photo)
        holder.tvName.text = food.name
        holder.tvDescription.text = food.desc

        holder.itemView.setOnClickListener {

                onItemClick?.invoke(food)
        }
    }

    override fun getItemCount(): Int = listFoods.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    }
