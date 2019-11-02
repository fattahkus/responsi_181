package com.fatkus.quis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class AccountActivity : AppCompatActivity() {
    private lateinit var name: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        name = findViewById(R.id.usr_name)

        if(supportActionBar != null){
            (supportActionBar as ActionBar).title = "Account"
        }

        val bundle = intent.extras
        val user_Name = bundle?.get("data_name1").toString()
        val user_uNme = bundle?.get("data_u_name1").toString()
        val user_Email = bundle?.get("data_email1").toString()

        name.text = user_Name
//        name.setText(intent.getStringExtra("data_u_name1"))

    }
}
