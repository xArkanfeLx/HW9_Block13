package com.example.hw8_recyclerview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {

    private val items = mutableListOf(
        Item("Первые штаны","Просто штаны", R.drawable.pant1),
        Item("Вторые штаны","Просто штаны", R.drawable.pant2),
        Item("Третьи штаны","Любимые штаны", R.drawable.pant3),
        Item("Четвёртые штаны","Просто штаны", R.drawable.pant4),
        Item("Пятые штаны","Просто штаны", R.drawable.pant5),
        Item("Шестые штаны","Просто штаны", R.drawable.pant6),
        Item("Первая кофта","Просто кофта", R.drawable.jacket1),
        Item("Вторая кофта","Просто кофта", R.drawable.jacket2),
        Item("Третья кофта","Просто кофта", R.drawable.jacket3),
        Item("Четвёртая кофта","Просто кофта", R.drawable.jacket4),
        Item("Пятая кофта","Просто кофта", R.drawable.jacket5),
        Item("Шестая кофта","Любимая кофта", R.drawable.jacket6),
        Item("Первая обувь","Любимая обувь", R.drawable.shoes1),
        Item("Вторая обувь","Просто обувь", R.drawable.shoes2),
        Item("Третья обувь","Просто обувь", R.drawable.shoes3),
        Item("Четвёртая обувь","Просто обувь", R.drawable.shoes4),
        Item("Пятая обувь","Любимая обувь", R.drawable.shoes5),
        Item("Шестая обувь","Просто обувь", R.drawable.shoes6),
        Item("Первая шапка","Когда +- тепло", R.drawable.cap1),
        Item("Вторая шапка","Когда похолоднее", R.drawable.cap2)
    )

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

    private fun init() {
        toolbarTB = findViewById(R.id.toolbarTB)
        setSupportActionBar(toolbarTB)

        recyclerRV = findViewById(R.id.recyclerRV)
        recyclerRV.layoutManager = LinearLayoutManager(this@SecondActivity)
        recyclerRV.adapter = CustomAdapter(items)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}