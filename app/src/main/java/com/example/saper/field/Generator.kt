package com.example.saper.field

abstract class Generator {
    private lateinit var field: Array<Array<Boolean>>

    fun generateField(weight: Int, height: Int) {
        field = Array(height) { Array<Boolean>(weight) { false } }
    }
}