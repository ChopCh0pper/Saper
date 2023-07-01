package com.example.saper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.GridView
import com.example.saper.constance.Constance
import com.example.saper.databinding.ActivityFieldBinding
import com.example.saper.field.FieldGenerator
import com.example.saper.field.Generator
import java.util.Objects

class Field : AppCompatActivity() {
    private lateinit var vb: ActivityFieldBinding
    private val fieldGenerator = FieldGenerator()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityFieldBinding.inflate(layoutInflater)
        setContentView(vb.root)

        val resultDifficult = intent.getIntExtra(Constance.INTENT_GAME_SETTINGS, 0)

        when(resultDifficult) {
            Constance.INTENT_VALUE_EASY -> {
                fieldGenerator.generateEasyField()
                fieldDisplay(fieldGenerator.getField(), vb.field)
            }


            Constance.INTENT_VALUE_HIGH -> {
                fieldGenerator.generateHighField()
                fieldDisplay(fieldGenerator.getField(), vb.field)
            }


            Constance.INTENT_VALUE_MIDL -> {
                fieldGenerator.generateMidlField()
                fieldDisplay(fieldGenerator.getField(), vb.field)
            }

        }
    }

    fun fieldDisplay(field: Array<Array<Generator.Cell>>, gridView: GridView) {
        val flatList = field.flatten()
        val adapter = MyAdapter(this, flatList)
        gridView.adapter = adapter
    }
}