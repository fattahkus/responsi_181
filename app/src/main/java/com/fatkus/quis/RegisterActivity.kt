package com.fatkus.quis

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {

    private lateinit var name: TextInputLayout
    private lateinit var username: TextInputLayout
    private lateinit var email: TextInputLayout
    private lateinit var password: TextInputLayout

    private lateinit var submit: Button
    private lateinit var back: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initComponet()

    }

    private fun initComponet() {

        initToolbar()

    }

    private fun initToolbar() {

        supportActionBar?.title = ("Signup Form")

        initForm()

    }

    private fun initForm() {

        name = findViewById(R.id.til_name)
        username = findViewById(R.id.til_username)
        email = findViewById(R.id.til_email)
        password = findViewById(R.id.til_password)

        submit = findViewById(R.id.submit)
        back = findViewById(R.id.back)

        submit.setOnClickListener {
            validateForm()
        }

        back.setOnClickListener {
            finish()
        }
    }

    private fun validateForm() {

        name.error = null
        username.error = null
        email.error = null
        password.error = null

        if (name.editText?.text.toString().isEmpty()) {

            name.error = "Your name can't be empty"

            return
        }

        if (username.editText?.text.toString().isEmpty()) {

            username.error = "Your username can't be empty"

            return
        }

        if (email.editText?.text.toString().isEmpty()) {

            email.error = "Your email can't be empty"

            return
        }

        if (password.editText?.text.toString().isEmpty()) {

            password.error = "Your password can't be empty"

            return
        }

        // Program Intent
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("data_name", name.editText?.text.toString())
            intent.putExtra("data_u_name", username.editText?.text.toString())
            intent.putExtra("data_email", email.editText?.text.toString())
            intent.putExtra("data_password", password.editText?.text.toString())

            showToast("Your Signup was successful", false)


        startActivity(intent)
    }

    private fun showToast(message: String, areLong: Boolean = true) {
        Toast.makeText(
            applicationContext,
            message,
            if (areLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
        ).show()
    }

}
