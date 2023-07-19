package com.example.saper

import FieldGenerator
import android.widget.Chronometer
import com.example.saper.constance.Constance

class Game(private val difficult: Int, private val timer: Chronometer) {

    private val fieldGenerator = FieldGenerator()
    private var isGameOver = false
    private var isGameContinue = false

    data class Cell(var isBomb: Boolean = false, var bombCount: Int = 0,
                    var isFlag: Boolean = false, var isClosed: Boolean = true)

    private lateinit var field: Array<Array<Cell>>
    fun getField(): Array<Array<Cell>> {
        return field
    }

    init {
        when(difficult) {
            Constance.INTENT_VALUE_EASY -> field = fieldGenerator.generateEasyField()
            Constance.INTENT_VALUE_MIDL -> field = fieldGenerator.generateMidlField()
        }
    }

    fun userClicked(x: Int, y: Int) {
        var cell = field[x][y]

        if (!isGameOver) {

            if(cell.isClosed) {
                if (cell.isBomb) gameOver()
                else gameContinue()
            }

        }

    }

    private fun gameOver() {

        isGameOver = true
        timer.stop()


    }

    private fun gameContinue() {

    }
}