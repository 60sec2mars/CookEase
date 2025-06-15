package com.practice.recipesapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe")
data class Recipe(
    @PrimaryKey val id: Int,
    val title: String,
    val image: String,
    val description: String,
    val ingredients: String,
    val category: String
)