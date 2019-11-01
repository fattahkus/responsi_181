package com.fatkus.quis

import android.drm.DrmStore
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_account.*

class AccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        if(supportActionBar != null){
            (supportActionBar as ActionBar).title = "Account"
        }

        val bundle = intent.extras
        val user_Name = bundle?.get("data_name1").toString()
        val user_uNme = bundle?.get("data_u_name1").toString()
        val user_Email = bundle?.get("data_email1").toString()

        usr_name.text = user_Name

    }
}
