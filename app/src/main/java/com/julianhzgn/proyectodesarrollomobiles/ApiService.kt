package com.julianhzgn.proyectodesarrollomobiles

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//interface ApiService {

//    @GET("/recipes/complexSearch?query={ingredient}&apiKey=e71fb43c3d0a4578845ec750cd79bcce")
//    suspend fun getFood(@Path("ingredient") ingredientName: String): Response<IngredientDataResponse>
interface ApiService {

    @GET("/recipes/complexSearch")
    suspend fun getFood(
        @Query("query") ingredientName: String,
        @Query("apiKey") apiKey: String
    ): Response<IngredientDataResponse>
}
