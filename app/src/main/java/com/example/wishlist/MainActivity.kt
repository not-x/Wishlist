package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var items: MutableList<Item>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize items
        items = arrayListOf()
        val itemsRv = findViewById<RecyclerView>(R.id.itemsRv)
        var adapter = ItemAdapter(items)

        val submitButton = findViewById<Button>(R.id.submitButton)
        val item = findViewById<EditText>(R.id.itemInput)
        val itemURL = findViewById<EditText>(R.id.itemURLInput)
        val itemPrice = findViewById<EditText>(R.id.itemPriceInput)
        itemsRv.adapter = adapter
        itemsRv.layoutManager = LinearLayoutManager(this)

        submitButton.setOnClickListener {
            items.add(Item(item.text.toString(), itemPrice.text.toString(), itemURL.text.toString()))
            item.getText().clear()
            itemPrice.getText().clear()
            itemURL.getText().clear()
            adapter = ItemAdapter(items)
            adapter.notifyDataSetChanged()
            itemsRv.adapter = adapter
            itemsRv.layoutManager = LinearLayoutManager(this)

            /*
            val toast = Toast.makeText(applicationContext, "Current size: " + items.size,
                Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            toast.show()
            */
        } // submitButton listener
    } // onCreate()
}