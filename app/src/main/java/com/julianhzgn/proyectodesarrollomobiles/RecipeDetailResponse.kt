package com.julianhzgn.proyectodesarrollomobiles

import com.google.gson.annotations.SerializedName

data class RecipeDetailResponse(
        @SerializedName("title") val title: String,
        @SerializedName("readyInMinutes") val readyInMinutes: String,
        @SerializedName("servings") val servings: String,
        @SerializedName("summary") val summary: String,
        @SerializedName("image") val image: String
)