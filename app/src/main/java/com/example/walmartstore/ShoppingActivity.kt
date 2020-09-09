package com.example.walmartstore

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.shopping_activity.*
import kotlinx.android.synthetic.main.shopping_ticket.view.*

class ShoppingActivity : AppCompatActivity() {

    // Declare an object of own Adapter - Customized GridView
    var adapter:ProductAdapter?=null

    // Initialize the ArrayList of Food object
    var listOfProducts = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_activity)

        // Getting the intent from MainActivity
        val intt = intent
        val output = intt.getStringExtra("username")
        rmsg.text = output // Puth the "username" in the shopping activity view

        // Load listOfProducts with the items
        listOfProducts.add(Product("Electronics","   The coolest gadgets in the market",R.drawable.electronics))
        listOfProducts.add(Product("Clothing","    The best for every season" ,R.drawable.clothings))
        listOfProducts.add(Product("Beauty","   Health top quality beauty products",R.drawable.beauty))
        listOfProducts.add(Product("Food"," From the market to your table",R.drawable.food))

        adapter= ProductAdapter(this,listOfProducts)

        // Assign the adapter
        gvListProducts.adapter = adapter
    }

    // Customize your Adapter by inheriting from BaseAdapter
    class  ProductAdapter: BaseAdapter {
        // Adapter need to display list of products
        var listOfProducts= ArrayList<Product>()
        var context: Context?=null

        // accepts a context and list of products, then call parent default constructor
        constructor(context: Context, listOfProducts:ArrayList<Product>):super(){
            this.context=context
            this.listOfProducts=listOfProducts
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val product = this.listOfProducts[p0]

            // Inflate your own layout into your adapter
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var productView= inflator.inflate(R.layout.shopping_ticket,null)
            //var productView= inflator.inflate(R.layout.clothing_list,null)

            // Set the items on your own layout view
            productView.ivProductImage.setImageResource(product.image!!)

            productView.ivProductImage.setOnClickListener {

                // Clothing ListView
                if ( getItemId(p0)== 1L) {
                    var tstinv = Toast.makeText(context, product.name, Toast.LENGTH_SHORT)
                    tstinv.setGravity(Gravity.TOP,0,0)
                    tstinv.show()


                    // Intent to Shopping Details
                    val intent = Intent(context, ClothingList::class.java)
                    context!!.startActivity(intent)

                }

                // Electronics RecyclerListView
                if (getItemId(p0)==0L) {
                    // Intent to Shopping Details
                    val intent = Intent(context, ElectronicsList::class.java)
                    context!!.startActivity(intent)
                }

                // Toast message
                var tstinv = Toast.makeText(context, product.name, Toast.LENGTH_LONG)
                tstinv.setGravity(Gravity.TOP,0,0)
                tstinv.show()

                // Intent to Shopping Details
                val intent = Intent(context, ShoppingDetails::class.java)
                intent.putExtra("name",product.name!!)
                intent.putExtra("des",product.des!!)
                intent.putExtra("image",product.image!!)
                context!!.startActivity(intent)
            }

            productView.tvName.text =  product.name!!
            return  productView

        }

        override fun getItem(p0: Int): Any {
            return listOfProducts[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listOfProducts.size
        }

    }

}