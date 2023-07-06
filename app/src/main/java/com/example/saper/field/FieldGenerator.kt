package com.example.saper.field

class FieldGenerator: Generator() {
    private val COLS_EASY = 9
    private val COLS_MIDL = 16

    private val ROWS_EASY = 9
    private val ROWS_MIDL = 16

    private val BOMBS_EASY = 12
    private val BOMBS_MIDL = 45

    fun generateEasyField() {
        generateField(ROWS_EASY, COLS_EASY)
        generateBombs(BOMBS_EASY)
        generateNumbers()
    }
    fun generateMidlField() {
        generateField(ROWS_MIDL, COLS_MIDL)
        generateBombs(BOMBS_MIDL)
        generateNumbers()
    }
}