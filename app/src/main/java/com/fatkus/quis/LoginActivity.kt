package com.fatkus.quis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import kotlinx.android.synthetic.main.layout_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var log_u_name : EditText
    private lateinit var log_email : EditText
    private lateinit var log_password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        supportActionBar?.title=("Login Form")

        log_u_name = findViewById(R.id.log_edt_inpt_email)
        log_email = findViewById(R.id.log_edt_inpt_email)
        log_password = findViewById(R.id.log_edt_inpt_password)

        log_cirLoginButton.setOnClickListener {
            if(log_u_name.text.toString()==intent.getStringExtra("data_u_name")&&log_email.text.toString()==intent.getStringExtra("data_email")&&log_password.text.toString()==intent.getStringExtra("data_password")){
                toast("You have successfully logged in",Toast.LENGTH_SHORT)
                val intent = Intent(this,HomeActivity::class.java)
            }else{
                toast("Your username or password is incorrect", LENGTH_LONG)
            }

        }
    }
    private fun toast (message: String, length: Int = LENGTH_LONG){
        Toast.makeText(this,message,length).show()
    }
}
