package com.example.submissionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class detail : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_detail)

            val myData = intent.getParcelableExtra<Foods>("myData")
            if(myData != null) {
                val nameTextView: TextView = findViewById(R.id.heading)
                val descTextView: TextView = findViewById(R.id.news)
                val photoImageView: ImageView = findViewById(R.id.image_heading)
                val bahanTextView : TextView = findViewById(R.id.detail_bahan)
                val resepTextView : TextView = findViewById(R.id.detail_resep)

                nameTextView.text = myData.name ?: "No name"
                descTextView.text = myData.desc ?: "No description"
                bahanTextView.text = myData.bahan ?: "No detail"
                resepTextView.text = myData.resep ?: "No detail"
                photoImageView.setImageResource(myData.photo)

            }
        }
    }