package com.fatkus.quis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fatkus.quis.adapter.ListProductAdapter
import com.fatkus.quis.model.Product
import com.fatkus.quis.model.ProductData
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private lateinit var rvProduct: RecyclerView
    private var list: ArrayList<Product> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvProduct = findViewById(R.id.rv_product)
        rvProduct.setHasFixedSize(true)
        list.addAll(ProductData.listProduct)
        showProductList()
    }
    private fun showProductList(){
        rvProduct.layoutManager = LinearLayoutManager(this)
        val listProductAdapter = ListProductAdapter(list)
        rvProduct.adapter = listProductAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.user_profil, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int){
        when(selectedMode){
            R.id.user_profil -> {
                intent= Intent(this, AccountActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
