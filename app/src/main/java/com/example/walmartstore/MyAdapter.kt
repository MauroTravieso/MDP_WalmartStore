package com.example.walmartstore

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

//class MyAdapter(var context:Context, var text1 :Array<String>, var text2:Array<String>,var img:IntArray,var text3 : Array<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
class MyAdapter(var context:Context,
                var text1 :Array<String>,
                var text2:Array<String>,
                var text3 : Array<String>,
                var img:IntArray,
                var text4 : Array<String>,
                var text5 : Array<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.im.setImageResource(img[position])
        holder.t1.text = text1[position]
        holder.t2.text = text2[position]
        holder.t3.text = text3[position]

        holder.parentlayout.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            var res = text1[position]
            Toast.makeText(context," $res clicked",Toast.LENGTH_LONG).show()
            intent.putExtra("image", img[position])
            intent.putExtra("title", text1[position])
            intent.putExtra("color", text3[position])
            intent.putExtra("itemid",text4[position])
            intent.putExtra("desc",  text5[position])
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(v);
    }

    override fun getItemCount(): Int {
        return text1.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var t1: TextView = itemView.findViewById<TextView>(R.id.tv1)
        var t2: TextView = itemView.findViewById<TextView>(R.id.tv2)
        var t3: TextView = itemView.findViewById<TextView>(R.id.tv3)
        var im : ImageView = itemView.findViewById<ImageView>(R.id.imageView)
        var parentlayout : RelativeLayout = itemView.findViewById(R.id.playout) as RelativeLayout
    }
}