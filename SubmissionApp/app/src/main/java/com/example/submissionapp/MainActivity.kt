package com.example.submissionapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvFoods: RecyclerView
    private val list = ArrayList<Foods>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFoods = findViewById(R.id.rv_food)
        rvFoods.setHasFixedSize(true)
        list.addAll(getListFoodses())
        showRecyclerList()
    }

    private fun getListFoodses(): ArrayList<Foods> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_pics)
        val listFoods = ArrayList<Foods>()
        for (i in dataName.indices) {
            val Foods = Foods(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listFoods.add(Foods)
        }
        return listFoods
    }

    fun showRecyclerList() {
        rvFoods.layoutManager = LinearLayoutManager(this)
        val listFoodsAdapter = ListFoodsAdapter(list)
        rvFoods.adapter = listFoodsAdapter

        listFoodsAdapter.onItemClick= {
                    val intent = Intent(this@MainActivity, detail::class.java)
                    intent.putExtra("myData", it)
                    startActivity(intent)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.user_detail -> {
                val intent = Intent(this, About::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



}