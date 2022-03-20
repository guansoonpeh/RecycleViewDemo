package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.data.Product
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ProductAdapter.onItemClickListener {
    private lateinit var binding : ActivityMainBinding
    private val productList = listOf( Product("P001", "Ball Pen", 2.50),
                                       Product("P002", "Pencil", 1.50) )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.productRecycleView.adapter = ProductAdapter(productList, this)
        binding.productRecycleView.layoutManager = LinearLayoutManager(application)
        binding.productRecycleView.setHasFixedSize(true)


    }

    override fun itemClick(position: Int) {
        Toast.makeText(application, productList[position].name, Toast.LENGTH_LONG).show()
    }


}