package com.example.saper

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.Display
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.saper.constance.Constance
import com.example.saper.databinding.ActivityFieldBinding
import com.example.saper.databinding.GridItemBinding
import com.example.saper.field.FieldGenerator
import com.example.saper.field.Generator
import kotlin.math.log

class Field : AppCompatActivity() {
    private lateinit var vb: ActivityFieldBinding
    private lateinit var gridItem: GridItemBinding
    private val fieldGenerator = FieldGenerator()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityFieldBinding.inflate(layoutInflater)
        setContentView(vb.root)

        gridItem = GridItemBinding.inflate(layoutInflater)

        val resultDifficult = intent.getIntExtra(Constance.INTENT_GAME_SETTINGS, 0)

        when(resultDifficult) {
            Constance.INTENT_VALUE_EASY -> {
                fieldGenerator.generateEasyField()
                fieldDisplay(fieldGenerator.getField(), vb.field)
            }

            Constance.INTENT_VALUE_MIDL -> {
                fieldGenerator.generateMidlField()
                fieldDisplay(fieldGenerator.getField(), vb.field)
            }

        }
    }

    fun fieldDisplay(field: Array<Array<Generator.Cell>>, gridView: GridView) {
        val widthField = field.size
        gridView.numColumns = widthField
        gridView.stretchMode = GridView.STRETCH_COLUMN_WIDTH

        val flatList = field.flatten()
        val adapter = MyAdapter(this, flatList, widthField)

        gridView.adapter = adapter
    }

}