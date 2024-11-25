package com.example.hw8_recyclerview

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {

    private val wardrobeDB = WardrobeDB()
    private var items:MutableList<Item> = mutableListOf()

    private lateinit var toolbarTB: Toolbar
    private lateinit var recyclerRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init()

    }

    override fun onResume() {
        super.onResume()
        reInitAdapter()
    }

    private fun reInitAdapter(){
        val adapter = CustomAdapter(items)
        recyclerRV.adapter = adapter
        recyclerRV.setHasFixedSize(true)
        adapter.setOnItemClickListener(object:
            CustomAdapter.OnItemClickListener {
            override fun onItemClick(item: Item, position: Int) {
                val intent = Intent(this@SecondActivity,InfoActivity::class.java)
                intent.putExtra("index",position)
                intent.putExtra("item",item)
                startActivity(intent)
            }
        })
    }

    private fun init() {
        items=wardrobeDB.getItems()
        toolbarTB = findViewById(R.id.toolbarTB)
        setSupportActionBar(toolbarTB)
        recyclerRV = findViewById(R.id.recyclerRV)
        recyclerRV.layoutManager = LinearLayoutManager(this@SecondActivity)
        reInitAdapter()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finishAffinity()
        return super.onOptionsItemSelected(item)
    }
}