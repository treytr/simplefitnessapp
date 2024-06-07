package com.example.myfitnessapp.model


data class Upload(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val uploadedBy: String,
    val timestamp: Long
)