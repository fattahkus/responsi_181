package com.fatkus.quis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fatkus.quis.adapter.ListProductAdapter
import com.fatkus.quis.model.Product
import com.fatkus.quis.model.ProductData
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private lateinit var rvProduct: RecyclerView
    private var list: ArrayList<Product> = arrayListOf()

    private lateinit var user_profil: TextView

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

        listProductAdapter.setOnItemClickCallback (object : ListProductAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Product) {
                showSelectedProduct(data)
            }
        })
    }
    private fun showSelectedProduct(data: Product) {
        Toast.makeText(this, data.name, Toast.LENGTH_LONG).show()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.user_profil, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //setMode(item.itemId)
//                val bundle = intent.extras
//                val user_Name = bundle?.get("data_name1").toString()
//                val user_uNme = bundle?.get("data_u_name1").toString()
//                val user_Email = bundle?.get("data_email1").toString()

        val id = item.getItemId()

        if(id == R.id.user_profil){
                user_profil.setOnClickListener {
                intent = Intent(this, AccountActivity::class.java)
                startActivity(intent)
           }
            return true
        }

        return super.onOptionsItemSelected(item)
    }
//    private fun setMode(selectedMode: Int){
//        when(selectedMode){
//            R.id.user_profil -> {
//                val bundle = intent.extras
//                val user_Name = bundle?.get("data_name1").toString()
//                val user_uNme = bundle?.get("data_u_name1").toString()
//                val user_Email = bundle?.get("data_email1").toString()
//
//                intent= Intent(this, AccountActivity::class.java)
//                intent.putExtra("data_name1", user_Name)
//                startActivity(intent)
//            }
//        }
//    }
}
