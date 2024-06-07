package com.example.myfitnessapp.model

data class User(
    val id: String,
    val name: String,
    val age: String,
    val weight: Float,
    val height: Float,
    val email: String,
    val password: String
) {
    fun calculateBMI(): Float {
        return weight / ((height / 100) * (height / 100))
    }
}