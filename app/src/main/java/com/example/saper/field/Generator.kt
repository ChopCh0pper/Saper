package com.example.saper.field

import java.util.Random


abstract class Generator{
    private lateinit var field: Array<Array<Cell>>
    private var bombCount = 0
    fun getbombCount(): Int {
        return bombCount
    }
    fun getField(): Array<Array<Cell>> {
        return field
    }

    protected fun generateField(rows: Int, cols: Int){
        field = Array(rows) { Array(cols) { Cell() } }
    }
    protected fun generateBombs(bombCount: Int) {
        val random = Random()
        var bombsPlaced = 0

        while (bombsPlaced < bombCount) {
            val row = random.nextInt(field.size)
            val col = random.nextInt(field[0].size)

            if (field[row][col].isBomb) {
                continue
            }

            field[row][col].isBomb = true
            bombsPlaced++
        }
        this.bombCount = bombCount
    }

    protected fun generateNumbers() {
        val deltas = arrayOf(
            intArrayOf(-1, -1), intArrayOf(-1, 0), intArrayOf(-1, 1),
            intArrayOf(0, -1), intArrayOf(0, 1),
            intArrayOf(1, -1), intArrayOf(1, 0), intArrayOf(1, 1)
        )

        for (row in 0 until field.size) {
            for (col in 0 until field[0].size) {
                if (field[row][col].isBomb) {
                    continue
                }

                var bombCount = 0
                for (delta in deltas) {
                    val newRow = row + delta[0]
                    val newCol = col + delta[1]

                    if (newRow in 0 until field.size && newCol in 0 until field[0].size && field[newRow][newCol].isBomb) {
                        bombCount++
                    }
                }

                field[row][col].bombCount = bombCount
            }
        }
    }


    data class Cell(var isBomb: Boolean = false, var bombCount: Int = 0,
                    var isFlag: Boolean = false, var isClosed: Boolean = true)
}
