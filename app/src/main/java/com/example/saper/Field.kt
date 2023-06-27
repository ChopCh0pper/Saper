package com.example.saper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.saper.constance.Constance
import com.example.saper.databinding.ActivityFieldBinding
import com.example.saper.field.FieldGenerator
import java.util.Objects

class Field : AppCompatActivity() {
    private lateinit var vb: ActivityFieldBinding
    private lateinit var field: FieldGenerator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityFieldBinding.inflate(layoutInflater)
        setContentView(vb.root)

        val resultDifficult = intent.getIntExtra(Constance.INTENT_GAME_SETTINGS, 0)

        when(resultDifficult) {
            Constance.INTENT_VALUE_EASY ->
                field.generateEasyField()
            Constance.INTENT_VALUE_MIDL ->
                field.generateMidlField()
            Constance.INTENT_VALUE_HIGH ->
                field.generateHighField()
        }
    }
}