package com.fatkus.quis

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private lateinit var username: TextInputLayout
    private lateinit var uname: TextView
    private lateinit var password: TextInputLayout

    private lateinit var submit: Button
    private lateinit var registration: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

        initComponent()

        uname = findViewById(R.id.hsl_username)
        uname.setText(intent.getStringExtra("data_u_name"))

    }

    private fun initComponent() {

        initForm()

    }

    private fun initForm() {

        username = findViewById(R.id.til_username)
        password = findViewById(R.id.til_password)

        submit = findViewById(R.id.submit)
        registration = findViewById(R.id.registration)

        submit.setOnClickListener {
            validateForm()
        }

        registration.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }

    private fun validateForm() {
        val bundle = intent.extras
        val user_regName = bundle?.get("data_neme").toString()
        val user_regUsername = bundle?.get("data_u_name").toString()
        val user_regEmail = bundle?.get("data_email").toString()
        val user_regPassword = bundle?.get("data_password").toString()

        if (username.editText?.text.toString().isEmpty()) {

            username.error = "Your username can't be empty"

            return
        }

        if (password.editText?.text.toString().isEmpty()) {

            password.error = "Your password can't be empty"

            return
        }
//||username.editText?.text.toString()==user_regEmail
        if(username.editText?.text.toString()==user_regUsername||username.editText?.text.toString()==user_regEmail&&password.editText?.text.toString()==user_regPassword){

            intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("data_name1", user_regName)
            intent.putExtra("data_u_name1", user_regUsername)
            intent.putExtra("data_email1", user_regEmail)
            intent.putExtra("data_password1", user_regPassword)

            Toast.makeText(applicationContext, "You have successfully logged in", Toast.LENGTH_SHORT).show()
            startActivity(intent)
         //   startActivity(Intent(applicationContext, HomeActivity::class.java))

            } else {

            Toast.makeText(
                applicationContext,
                "Invalid username or password!",
                Toast.LENGTH_SHORT
            ).show()

        }

    }

}
