package com.fatkus.quis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.bumptech.glide.Glide

class DetailProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        var Photo : ImageView = findViewById(R.id.dt_pict)
        var Name : TextView = findViewById(R.id.dt_name)
        var Detail: TextView = findViewById(R.id.dt_desk)

        val name = intent.getStringExtra(SHOW_NAME)
        val detail = intent.getStringExtra(SHOW_DETAIL)
        val image = intent.getIntExtra(SHOW_PHOTO, 0)

        Glide.with(this)
            .load(image)
            .into(Photo)
        Name.text = name
        Detail.text = detail

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = name
        }

    }
    companion object{
        const val SHOW_NAME = "show_name"
        const val SHOW_DETAIL = "show_detail"
        const val SHOW_PHOTO = "show_photo"
    }

}
