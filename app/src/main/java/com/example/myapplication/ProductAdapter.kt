package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.Product

class ProductAdapter (private val myList :List<Product>, private val listener:onItemClickListener): RecyclerView.Adapter<ProductAdapter.myViewHolder>(){

    inner class myViewHolder (itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val pic :ImageView = itemView.findViewById(R.id.imageView)
        val tvcode : TextView = itemView.findViewById(R.id.tvCode)
        val tvName : TextView = itemView.findViewById(R.id.tvName)
        val tvPrice : TextView = itemView.findViewById(R.id.tvPrice)

        init {
            pic.setImageResource(R.drawable.ic_baseline_ad_units_24)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position:Int = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                listener.itemClick(position)
            }

        }

    }

    interface onItemClickListener {
        fun itemClick(position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_view, parent,false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val currentItem = myList[position]

        holder.tvName.text = currentItem.name
        holder.tvPrice.text = currentItem.price.toString()
        holder.tvcode.text = currentItem.code


    }

    override fun getItemCount(): Int {
        return myList.size
    }

}


