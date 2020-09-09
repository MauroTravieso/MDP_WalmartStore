package com.example.walmartstore

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.clothing_list.*

class ClothingList : AppCompatActivity() {

    var clothing_items = arrayOf<String>("Children", "Women", "Men")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.clothing_list)
        val adapter = ArrayAdapter<String>(this@ClothingList, android.R.layout.simple_spinner_dropdown_item, clothing_items)
        lview.adapter = adapter
        lview.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val item = parent.getItemAtPosition(position).toString()
                Toast.makeText(applicationContext, item, Toast.LENGTH_LONG).show()
            }

    }
}