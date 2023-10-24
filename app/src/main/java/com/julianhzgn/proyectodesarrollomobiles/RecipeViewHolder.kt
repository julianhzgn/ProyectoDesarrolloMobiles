package com.julianhzgn.proyectodesarrollomobiles

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.julianhzgn.proyectodesarrollomobiles.databinding.ItemRecipeBinding

class RecipeViewHolder(view:View): RecyclerView.ViewHolder(view) {

    private val binding = ItemRecipeBinding.bind(view)

    fun bind(RecipeItemResponse: RecipeItemResponse){
    binding.tvRecipeName.text = RecipeItemResponse.recipeTitle
    }
}