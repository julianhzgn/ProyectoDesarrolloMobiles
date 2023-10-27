package com.julianhzgn.proyectodesarrollomobiles

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {

    @GET("/recipes/complexSearch")
    suspend fun getFood(
        @Query("query") ingredientName: String,
        @Query("apiKey") apiKey: String
    ): Response<IngredientDataResponse>

    @GET
    suspend fun getRecipeDetail(@Url url: String): Response<RecipeDetailResponse>

}
