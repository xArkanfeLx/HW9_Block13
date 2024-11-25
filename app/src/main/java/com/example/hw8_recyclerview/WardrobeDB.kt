package com.example.hw8_recyclerview

import android.content.Context
import android.widget.Toast

class WardrobeDB {
    companion object {
        val items = mutableListOf(
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
    }

    fun getItems():MutableList<Item>{
        return items
    }

    fun updateItem(context: Context, index:Int, item:Item){
        items[index] = item
        Toast.makeText(context,"${items[index]}",Toast.LENGTH_LONG).show()
    }
}