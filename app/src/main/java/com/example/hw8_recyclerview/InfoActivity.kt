package com.example.hw8_recyclerview

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InfoActivity : AppCompatActivity() {

    private val wardrobeDB = WardrobeDB()
    private lateinit var layoutCL: ConstraintLayout

    private lateinit var toolbarTB: Toolbar
    private lateinit var imgIV: ImageView
    private lateinit var nameTV: TextView
    private lateinit var descriptionTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layoutCL)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init()

        val item = intent.getSerializableExtra("item") as Item
        val nowIndex = intent.extras!!.getInt("index")
        imgIV.setImageResource(item.img)
        nameTV.text = item.name
        descriptionTV.text = item.description

        layoutCL.setOnLongClickListener(
            View.OnLongClickListener {
                val dialog = AlertDialog.Builder(this)
                val inflater = this.layoutInflater
                val dialogView = inflater.inflate(R.layout.update_dialog, null)
                dialog.setView(dialogView)
                val editName: EditText = dialogView.findViewById(R.id.nameET)
                val editDescription: EditText = dialogView.findViewById(R.id.descriptionET)

                dialog.setTitle("Обновить запись")
                dialog.setMessage("Введите данные ниже")
                dialog.setPositiveButton("Обновить") { _, _ ->
                    val name = editName.text
                    val description = editDescription.text
                    nameTV.text = name
                    descriptionTV.text = description
                    val newItem = Item(name.toString(), description.toString(), item.img)
                    wardrobeDB.updateItem(this,nowIndex, newItem)
                }
                dialog.setNegativeButton("Отмена") { _, _ -> }
                dialog.create().show()
                false
            }
        )
    }

    private fun init() {
        layoutCL = findViewById(R.id.layoutCL)
        toolbarTB = findViewById(R.id.toolbarTB)
        setSupportActionBar(toolbarTB)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbarTB.setNavigationOnClickListener {
            onBackPressed()
        }

        imgIV = findViewById(R.id.imgIV)
        nameTV = findViewById(R.id.nameTV)
        descriptionTV = findViewById(R.id.descriptionTV)

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