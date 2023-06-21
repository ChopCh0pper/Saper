package com.example.saper.field

class FieldGenerator: Generator() {
    private val WEIGHT_EASY = 9
    private val WEIGHT_MIDL = 16
    private val WEIGHT_HIGH = 16
    private val HEIGHT_EASY = 9
    private val HEIGHT_MIDL = 16
    private val HIEGHT_HIGH = 30

    fun generateEasyField() {
        generateField(WEIGHT_EASY, HEIGHT_EASY)
    }
    fun generateMidlField() {
        generateField(WEIGHT_MIDL, HEIGHT_MIDL)
    }
    fun generateHighField() {
        generateField(WEIGHT_HIGH, HIEGHT_HIGH)
    }
}