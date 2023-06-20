package com.example.saper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.saper.databinding.ActivityGameSettingsBinding
import com.example.saper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var vb : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)

        //Надо будет реализовать проверку на наличие прогресса...
        //Пока что можно только начать новую игру

        vb.btNewGame.setOnClickListener {
            intent = Intent(this, GameSettings::class.java)
            startActivity(intent)
        }

        vb.btResum.setOnClickListener {

        }
    }
}