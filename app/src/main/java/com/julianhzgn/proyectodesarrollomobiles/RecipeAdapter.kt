package com.julianhzgn.proyectodesarrollomobiles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(
    var RecipeList: List<RecipeItemResponse> = emptyList(),
    private val onItemSelected: (String) -> Unit
) :
    RecyclerView.Adapter<RecipeViewHolder>() {

    fun updateList(recipeList: List<RecipeItemResponse>) {
        this.RecipeList = recipeList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        )
    }

    override fun onBindViewHolder(viewholder: RecipeViewHolder, position: Int) {
        viewholder.bind(RecipeList[position], onItemSelected)
    }

    override fun getItemCount() = RecipeList.size
}
