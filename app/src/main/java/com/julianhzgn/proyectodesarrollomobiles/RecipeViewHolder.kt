package com.julianhzgn.proyectodesarrollomobiles

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.julianhzgn.proyectodesarrollomobiles.databinding.ItemRecipeBinding
import com.squareup.picasso.Picasso

class RecipeViewHolder(view:View): RecyclerView.ViewHolder(view) {

    private val binding = ItemRecipeBinding.bind(view)

    fun bind(RecipeItemResponse: RecipeItemResponse, onItemSelected: (String) -> Unit){
    binding.tvRecipeName.text = RecipeItemResponse.recipeTitle
    Picasso.get().load(RecipeItemResponse.recipeImageURL).into(binding.ivRecipeItem)
    binding.root.setOnClickListener { onItemSelected(RecipeItemResponse.recipeId) }
    }
}