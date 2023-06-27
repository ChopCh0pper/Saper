package com.example.saper

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.saper.constance.Constance
import com.example.saper.databinding.ActivityGameSettingsBinding


class GameSettings : AppCompatActivity() {
    lateinit var vb: ActivityGameSettingsBinding
    private var selectedDifficult: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityGameSettingsBinding.inflate(layoutInflater)
        setContentView(vb.root)

        vb.btStartGame.isEnabled = false

        val intent = Intent(this, Field::class.java)


        vb.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val radioButtonSelected = checkedId != -1
            vb.btStartGame.isEnabled = radioButtonSelected
        }


        vb.btStartGame.setOnClickListener {
            intent.putExtra(Constance.INTENT_GAME_SETTINGS, selectedDifficult)
            startActivity(intent)
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.getId()) {
                R.id.rbEasy ->
                    if (checked) {selectedDifficult = Constance.INTENT_VALUE_EASY}
                R.id.rbMidl ->
                    if (checked) {selectedDifficult = Constance.INTENT_VALUE_MIDL}
                R.id.rbHigh ->
                    if (checked) {selectedDifficult = Constance.INTENT_VALUE_HIGH}
            }
        }
    }
}