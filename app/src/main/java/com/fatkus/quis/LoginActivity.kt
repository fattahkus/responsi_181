package com.fatkus.quis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.layout_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var log_u_name : TextInputEditText
    private lateinit var log_email : TextInputEditText
    private lateinit var log_password : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        supportActionBar?.title=("Login Form")

        log_u_name = findViewById(R.id.log_edt_inpt_email)
        log_email = findViewById(R.id.log_edt_inpt_email)
        log_password = findViewById(R.id.log_edt_inpt_password)

        log_cirLoginButton.setOnClickListener {
            if(log_u_name.text.toString()==intent.getStringExtra("data_u_name")&&log_email.text.toString()==intent.getStringExtra("data_email")&&log_password.text.toString()==intent.getStringExtra("data_password")){
                Toast.makeText(this@LoginActivity,"You have successfully logged in", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
            }else{
                Toast.makeText(this@LoginActivity,"Your username or password is incorrect", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
