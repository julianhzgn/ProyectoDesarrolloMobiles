package com.julianhzgn.proyectodesarrollomobiles

import com.google.gson.annotations.SerializedName

data class IngredientDataResponse(
    //@SerializedName("results") val responseInit: List<JSONArray>,
    @SerializedName("results") val results: List<RecipeItemResponse>
)

data class RecipeItemResponse(
    @SerializedName("id") val recipeId: String,
    @SerializedName("title") val recipeTitle: String,
    @SerializedName("image") val recipeImageURL: String,
    @SerializedName("imageType") val recipeImageType: String
)