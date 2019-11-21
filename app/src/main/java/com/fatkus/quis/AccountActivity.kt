package com.fatkus.quis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_account.*

class AccountActivity : AppCompatActivity() {
    private lateinit var name: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)


        val actionbar = supportActionBar
        if (actionbar != null) {
            (actionbar as ActionBar).title = "My Profil"
            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.setDisplayHomeAsUpEnabled(true)
        }

        val bundle = intent.extras
        val userName = bundle?.get("data_name1").toString()
        val userUName = bundle?.get("data_u_name1").toString()
        val userEmail = bundle?.get("data_email1").toString()

        usr_Name.text = userName
        usr_Username.text = userUName
        usr_email.text = userEmail

//        name.setText(intent.getStringExtra("data_u_name1"))

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
