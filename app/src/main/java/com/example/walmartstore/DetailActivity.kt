package com.example.walmartstore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail_layout.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_layout)
        // To avoid application crash check intent has data or not
        if(intent.hasExtra("image") &&
            intent.hasExtra("title") &&
            intent.hasExtra("color") &&
            intent.hasExtra("itemid") &&
            intent.hasExtra("desc")){

            var ig = intent.getIntExtra("image",0)
            var t1 = intent.getStringExtra("title")
            var t2 = intent.getStringExtra("color")
            var t3 = intent.getStringExtra("itemid")
            var t4 = intent.getStringExtra("desc")

            imageView.setImageResource(ig)
            tit.text = t1.toString()
            col.text = t2.toString()
            iid.text = t3.toString()
            des.text = t4.toString()
        }
    }
}