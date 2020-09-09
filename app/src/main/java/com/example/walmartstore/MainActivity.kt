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

    // List of Products
    var eproducts = ArrayList<EProduct>()

    // Eproducts
    val eproduct1 = EProduct(
        "RGA Voyager 7'' 16GB Android Table",
        35.00,
        "Black",
        "elect0",
        "000001",
        "Introducing the RCA Voyager 7-inch Google Certified Tablet. Operating on Android 8.1, you can enjoy more of what the Google Play store has to offer. Share a smile with friends and family using the tablet's front camera. Use the tablet's built-in Bluetooth capability to connect and pair with compatible devices. Whether taking in a movie, playing a favorite game or surfing the Web, the RCA tablet's quad-core processor and 16GB flash-storage surely won't disappoint.")
    val eproduct2 = EProduct(
        "HP Flyer Red 15.6'' Laptop",
        299.0,
        "Blak & Red",
        "elect1",
        "000002",
        "Intel Pentium N3540 processor4GB memory500GB hard driveWindows 10 HomeThis reliable, value-packed laptop combines the features you need to get the job done and a sleek, thin design you can easily take on the road. This item was manufactured in 2018.")
    val eproduct3 = EProduct(
        "VIZIO 70'' Class 4K",
        1298.00,
        "Black",
        "elect2",
        "000003",
        "Experience the next era of Smart TV with the 2018 SmartCast OS featuring voice control from Google Assistant and Amazon Alexa-enabled devices. Designed with an intuitive smart TV interface and offering thousands of apps with Google Chromecast built-in, SmartCast delivers the latest in 4K UHD & HDR entertainment. The all-new VIZIO Smart TVs come equipped with free automatic updates that add new features and apps." )
    val eproduct4 = EProduct(
        "Epson WorkForce WF-2750",
        69.0,
        "Black",
        "elect3",
        "000004",
        "Performance Beyond Laser Powered by PrecisionCore\n" +
            "PrecisionCore is a new printing technology using a revolutionary high-density print chip which can generate up to 40 million precise dots per second with astonishing accuracy, producing professional quality output at dramatic speeds.")
    val eproduct5 = EProduct(
        "Samsung Gear S2 Galaxy",
        99.99,
        "Dark gray",
        "elect4",
        "000005",
        "With rotating bezel and unique circular interface, easily access your apps and notifications.OS Tizen based wearable platform.Processor speed Dual core 1GHz exynos 3250\n" +
            "With a circular design and stainless steel construction, the Gear S2 matches your style\n" +
            "Thousands of third party apps available")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Populate the list of users
        users.add(user1)
        users.add(user2)
        users.add(user3)
        users.add(user4)
        users.add(user5)

        // Populate the list of products
        eproducts.add(eproduct1)
        eproducts.add(eproduct2)
        eproducts.add(eproduct3)
        eproducts.add(eproduct4)
        eproducts.add(eproduct5)
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