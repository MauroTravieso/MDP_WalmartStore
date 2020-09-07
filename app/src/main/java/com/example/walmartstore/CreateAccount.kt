package com.example.walmartstore

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.create_account.*
import kotlinx.android.synthetic.main.create_account.view.*

class CreateAccount : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account)

        ca_button.setOnClickListener {
            if (!fname.text.toString().isEmpty() && !lname.text.toString().isEmpty() && !new_email.text.isEmpty() && !new_password.text.isEmpty()) {
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()

                var new_user = User(fname.text.toString(), lname.text.toString(), new_email.text.toString(), new_password.text.toString())

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("new_user", new_user)
                setResult(Activity.RESULT_OK,intent)
                finish()
            }
        }

    }

}