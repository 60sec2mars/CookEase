package com.practice.recipesapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ScanIngredientsActivity : AppCompatActivity() {

    private lateinit var btnTakePhoto: Button
    private lateinit var etIngredients: EditText
    private lateinit var btnSubmitIngredients: Button
    private lateinit var backBtn: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_ingredients)

        btnTakePhoto = findViewById(R.id.btnTakePhoto)
        etIngredients = findViewById(R.id.etIngredients)
        btnSubmitIngredients = findViewById(R.id.btnSubmitIngredients)
        backBtn = findViewById(R.id.back_btn)

        backBtn.setOnClickListener {
            finish() // Navigates back to HomeActivity
        }

        btnTakePhoto.setOnClickListener {
            Toast.makeText(this, "Camera feature coming soon!", Toast.LENGTH_SHORT).show()
            // TODO: Implement camera capture + ML processing
        }

        btnSubmitIngredients.setOnClickListener {
            val ingredientsText = etIngredients.text.toString().trim()
            if (ingredientsText.isEmpty()) {
                Toast.makeText(this, "Please enter or scan ingredients", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Processing: $ingredientsText", Toast.LENGTH_SHORT).show()
                // TODO: Handle the input and recommend recipes
            }
        }
    }
}