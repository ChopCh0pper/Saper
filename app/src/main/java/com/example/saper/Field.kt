package com.example.saper

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.example.saper.constance.Constance
import com.example.saper.databinding.ActivityFieldBinding
import com.example.saper.field.Generator
import com.example.saper.game.FieldWidget
import com.example.saper.game.Game

class Field : AppCompatActivity() {
    private lateinit var vb: ActivityFieldBinding
    private lateinit var game: Game
    private lateinit var widget: FieldWidget
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityFieldBinding.inflate(layoutInflater)
        setContentView(vb.root)
        vb.timer.start()

        val resultDifficult = intent.getIntExtra(Constance.INTENT_GAME_SETTINGS, 0)
        game = Game(resultDifficult, vb.timer)
        widget = FieldWidget()

        fieldDisplay(game.getField(), vb.field)
        vb.timer.start()
    }

    fun fieldDisplay(field: Array<Array<Game.Cell>>, gridView: GridView) {
        val widthField = field.size
        gridView.numColumns = widthField
        gridView.stretchMode = GridView.STRETCH_COLUMN_WIDTH

        val adapter = MyAdapter(this, field, widthField)

        gridView.adapter = adapter

        adapter.clickListener = { x,y ->
            game.userClicked(x,y)
        }

        widget.onCellClick = {x,y -> game.userClicked(x,y)}

        game.onGameStateChangeListener = { state ->
            widget.setState(state)
        }
    }

}