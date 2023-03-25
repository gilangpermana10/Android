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

                nameTextView.text = myData.name ?: "No name"
                descTextView.text = myData.desc ?: "No description"
                photoImageView.setImageResource(myData.photo)

            }
        }
    }