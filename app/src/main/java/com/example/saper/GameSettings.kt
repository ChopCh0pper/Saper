package com.example.saper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.view.View
import android.widget.RadioButton
import com.example.saper.constance.Constance
import com.example.saper.databinding.ActivityGameSettingsBinding

class GameSettings : AppCompatActivity() {
    lateinit var vb: ActivityGameSettingsBinding
    lateinit var intent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityGameSettingsBinding.inflate(layoutInflater)
        setContentView(vb.root)

        vb.btStartGame.setOnClickListener {
            startActivity(intent)
        }
    }

    private fun setIntentValue(value: Int){
        intent = Intent(this, Field::class.java)
        intent.putExtra(Constance.INTENT_GAME_SETTINGS, value)
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.getId()) {
                R.id.rbEasy ->
                    if (checked) {setIntentValue(Constance.INTENT_VALUE_EASY)}
                R.id.rbMidl ->
                    if (checked) {setIntentValue(Constance.INTENT_VALUE_MIDL)}
                R.id.rbHigh ->
                    if (checked) {Constance.INTENT_VALUE_HIGH}
            }
        }
    }
}