package com.example.saper

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.example.saper.constance.Constance
import com.example.saper.databinding.ActivityFieldBinding
import com.example.saper.field.FieldGenerator
import com.example.saper.field.Generator

class Field : AppCompatActivity() {
    private lateinit var vb: ActivityFieldBinding
    private lateinit var game: Game
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityFieldBinding.inflate(layoutInflater)
        setContentView(vb.root)
        vb.timer.start()

        val resultDifficult = intent.getIntExtra(Constance.INTENT_GAME_SETTINGS, 0)
        game = Game(resultDifficult)

        vb.timer.start()
    }

    fun fieldDisplay(field: Array<Array<Generator.Cell>>, gridView: GridView) {
        val widthField = field.size
        gridView.numColumns = widthField
        gridView.stretchMode = GridView.STRETCH_COLUMN_WIDTH

        val flatList = field.flatten()
        val adapter = MyAdapter(this, flatList, widthField, vb.timer, vb.tvBombCount)

        gridView.adapter = adapter
    }

}