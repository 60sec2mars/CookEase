package com.practice.recipesapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practice.recipesapp.databinding.CategoryRvBinding

class CategoryAdapter(private val dataList: ArrayList<Recipe>, private val context: Context) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: CategoryRvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CategoryRvBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = dataList[position]

        Glide.with(context).load(recipe.image).into(holder.binding.img)
        holder.binding.tittle.text = recipe.title

        val ingredientsArray = recipe.ingredients.split("\n").filter { it.isNotBlank() }.toTypedArray()
        holder.binding.time.text = ingredientsArray.firstOrNull() ?: "Unknown"

        holder.binding.next.setOnClickListener {
            val intent = Intent(context, RecipeActivity::class.java).apply {
                putExtra("image", recipe.image)
                putExtra("title", recipe.title)
                putExtra("description", recipe.description)
                putExtra("ingredients", recipe.ingredients)
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        }
    }
}