package com.example.walmartstore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ElectronicsList : AppCompatActivity() {
    var r1: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var s1 : Array<String>?=null // title
    var s2 : Array<String>?=null // price
    var s3 : Array<String>?=null // color
    var s4 : Array<String>?=null // itemid
    var s5 : Array<String>?=null // desc
    var madr : MyAdapter?=null
    var imageges = intArrayOf(
        R.drawable.elect0,
        R.drawable.elect1,
        R.drawable.elect2,
        R.drawable.elect3,
        R.drawable.elect4
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.electronic_list)
        r1 = findViewById<RecyclerView>(R.id.rv)
        s1 = resources.getStringArray(R.array.title);
        s2 = resources.getStringArray(R.array.price);
        s3 = resources.getStringArray(R.array.color);
        s4 = resources.getStringArray(R.array.itemid)
        s5 = resources.getStringArray(R.array.desc)
        madr = MyAdapter(this,
            s1 as Array<String>,
            s2 as Array<String>,
            s3 as Array<String>,
            imageges,
            s4 as Array<String>,
            s5 as Array<String>)
        layoutManager = LinearLayoutManager(this)
        r1?.layoutManager = layoutManager
        r1?.adapter = madr

    }
}