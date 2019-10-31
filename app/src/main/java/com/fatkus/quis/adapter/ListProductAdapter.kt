package com.fatkus.quis.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fatkus.quis.R
import com.fatkus.quis.model.Product

class ListProductAdapter (private val listProduct: ArrayList<Product>) : RecyclerView.Adapter<ListProductAdapter.ProductViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListProductAdapter.ProductViewHolder {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_product, parent, false)
            return ProductViewHolder(view)
            }

    override fun getItemCount(): Int {
        return listProduct.size
    }

    override fun onBindViewHolder(holder: ListProductAdapter.ProductViewHolder, position: Int) {
        val product = listProduct[position]
        holder.tvName.text = product.name
        holder.tvDetail.text = product.detail
        Glide.with(holder.itemView.context)
            .load(product.photo)
            .load(holder.imgPhoto)
        holder.itemView.setOnClickListener{
            Toast.makeText(
                holder.itemView.context, "Kamu Memilih"+listProduct[holder.adapterPosition].name,
                Toast.LENGTH_LONG
            ).show()
        }
    }
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}
