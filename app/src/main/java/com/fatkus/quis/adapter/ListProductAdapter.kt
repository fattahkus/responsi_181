package com.fatkus.quis.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fatkus.quis.DetailProductActivity
import com.fatkus.quis.R
import com.fatkus.quis.model.Product
import com.fatkus.quis.model.ProductData.listProduct

class ListProductAdapter (val listProduct: ArrayList<Product>) : RecyclerView.Adapter<ListProductAdapter.ProductViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_product, parent, false)
            return ProductViewHolder(view)
            }

    override fun getItemCount(): Int {
        return listProduct.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = listProduct[position]
        holder.tvName.text = product.name
        holder.tvDetail.text = product.detail
        Glide.with(holder.itemView.context)
            .load(product.photo)
            .into(holder.imgPhoto)
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listProduct[holder.adapterPosition])

            val intent = Intent(it.context, DetailProductActivity::class.java)
            intent.putExtra(DetailProductActivity.SHOW_NAME,product.name)
            intent.putExtra(DetailProductActivity.SHOW_DETAIL,product.detail)
            intent.putExtra(DetailProductActivity.SHOW_PHOTO,product.photo)
            it.context.startActivity(intent)

        }
    }
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback{
        fun onItemClicked(data: Product)
    }
}
