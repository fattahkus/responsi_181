package com.fatkus.quis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.layout_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var dt_name : EditText
    private lateinit var dt_u_name : EditText
    private lateinit var dt_email : EditText
    private lateinit var dt_password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        dt_name = findViewById(R.id.reg_edt_inpt_name)
        dt_u_name = findViewById(R.id.reg_edt_inpt_u_name)
        dt_email = findViewById(R.id.reg_edt_inpt_email)
        dt_password = findViewById(R.id.reg_edt_inpt_password)

        supportActionBar?.title=("Signup Form")

        reg_cirSignupButton.setOnClickListener{
            if(reg_edt_inpt_name.text.toString().isEmpty()){
              //  toast("Your name can't be empty", Toast.LENGTH_LONG)
                Toast.makeText(this@RegisterActivity,"Your name can't be empty", Toast.LENGTH_SHORT).show()
            }else if(reg_edt_inpt_u_name.text.toString().isEmpty()){
                toast("Your username can't be empty", Toast.LENGTH_LONG)
            }else if(reg_edt_inpt_email.text.toString().isEmpty()){
                toast("Your email can't be empty", Toast.LENGTH_LONG)
            }else if(reg_edt_inpt_password.text.toString().isEmpty()){
                toast("Your password can't be empty", Toast.LENGTH_LONG)
            }else if(reg_edt_inpt_name.text.toString().isEmpty()||reg_edt_inpt_u_name.text.toString().isEmpty()||reg_edt_inpt_email.text.toString().isEmpty()||reg_edt_inpt_password.text.toString().isEmpty()) {
                toast("Your Signup was successful", Toast.LENGTH_LONG)

                // Program Intent
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("data_name", dt_name.text.toString())
                intent.putExtra("data_u_name", dt_u_name.text.toString())
                intent.putExtra("data_email", dt_email.text.toString())
                intent.putExtra("data_password", dt_password.text.toString())
                startActivity(intent)
            }
        }
    }private fun toast(message: String, length: Int = Toast.LENGTH_LONG){
        Toast.makeText(this,message,length).show()
    }
}
