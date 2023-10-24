package com.julianhzgn.proyectodesarrollomobiles

import com.google.gson.annotations.SerializedName

data class IngredientDataResponse(
    //@SerializedName("results") val responseInit: List<JSONArray>,
    @SerializedName("results") val results: List<RecipeItemResponse>
)

data class RecipeItemResponse(
    @SerializedName("id") val recipeId: Int,
    @SerializedName("title") val recipeTitle: String,
    @SerializedName("image") val recipeImage: String,
    @SerializedName("imageType") val recipeImageType: String
)