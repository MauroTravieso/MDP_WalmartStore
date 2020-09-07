package com.example.walmartstore

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.create_account.*

/**
 *  Kotlin Android Application: Walmart Store
 *
 *  Author: Mauro Travieso (986965)
 *
 *  Version: 1.0
 *  Bugs: none known
 */
class MainActivity : AppCompatActivity() {

    // List of Users initialization
    var users = ArrayList<User>()

    // Users
    val user1 = User("Olga","Pernia","olga@mail.com","olga")
    val user2 = User("Mauro","Travieso","mauro@mail.com","mauro")
    val user3 = User("Tita","Pernia","tita@mail.com","tita")
    val user4 = User("Rocky","Travieso","rocky@mail.com","rocky")
    val user5 = User("Vera","Fritton","vera@mail.com","vera")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Populate the list of users
        users.add(user1)
        users.add(user2)
        users.add(user3)
        users.add(user4)
        users.add(user5)

    }

    fun validateUser(view : View) {
        if (!email.text.toString().isEmpty() && !password.text.toString().isEmpty()) {
            val eml = email.text.toString()
            val pss = password.text.toString()

            for (user in users) {
                if (eml.equals(user.username) && pss.equals(user.password)) {
//                    var tstinv = Toast.makeText(applicationContext,"Welcome," + eml, Toast.LENGTH_SHORT)
//                    tstinv.setGravity(Gravity.TOP,0,0)
//                    tstinv.show()
//                    email.text.clear()
//                    password.text.clear()

                    // Intent (Open Shopping Activity)
                    var intent = Intent(this, ShoppingActivity::class.java)
                    intent.putExtra("username", "Welcome, " + eml)
                    startActivity(intent)
                    email.text.clear()
                    password.text.clear()
                }
//                else {
//                    var tstinv = Toast.makeText(applicationContext,"Invalid username or password!!!", Toast.LENGTH_SHORT)
//                    tstinv.setGravity(Gravity.TOP,0,0)
//                    tstinv.show()
//                    email.text.clear()
//                    password.text.clear()
//                }
            }
//            var tstinv = Toast.makeText(applicationContext,"Invalid username or password!!!", Toast.LENGTH_SHORT)
//            tstinv.setGravity(Gravity.TOP,0,0)
//            tstinv.show()
//            email.text.clear()
//            password.text.clear()

        }
    }

    fun createUser(view : View) {
        var intent = Intent(this, CreateAccount::class.java)
        startActivityForResult(intent,1)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val new_user = data!!.getSerializableExtra("new_user")
                users.add(new_user as User)
            }
        }
    }

    fun forgotPassword(view : View) {
        val eml = email.text.toString()
        Toast.makeText(this, "Forgot password?", Toast.LENGTH_LONG).show()
        for (user in users) {
            if (eml.equals(user.username)) {
                val fpass =  user.password
                // Implicit intent
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, fpass)
                if (intent.resolveActivity(getPackageManager())!=null) {
                    startActivity(intent)
                }
            }
        }
    }
}