package com.example.saper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.saper.constance.Constance
import com.example.saper.databinding.ActivityFieldBinding
import java.util.Objects

class Field : AppCompatActivity() {
    lateinit var vb: ActivityFieldBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityFieldBinding.inflate(layoutInflater)
        setContentView(vb.root)

        val resultDifficult = intent.getIntExtra(Constance.INTENT_GAME_SETTINGS, 0)


    }
}