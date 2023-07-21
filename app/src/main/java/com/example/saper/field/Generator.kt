package com.example.saper.field

import com.example.saper.game.Game
import java.util.Random


abstract class Generator{
    private var bombCount = 0
    fun getbombCount(): Int {
        return bombCount
    }

    protected fun generateField(rows: Int, cols: Int): Array<Array<Game.Cell>>{
        return Array(rows) { Array(cols) { Game.Cell() } }
    }
    protected fun generateBombs(bombCount: Int, field: Array<Array<Game.Cell>>): Array<Array<Game.Cell>> {
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

        return field
    }

    protected fun generateNumbers(field: Array<Array<Game.Cell>>): Array<Array<Game.Cell>> {
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
        return field
    }
}
