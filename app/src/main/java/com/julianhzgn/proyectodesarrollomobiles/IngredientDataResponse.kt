package com.julianhzgn.proyectodesarrollomobiles

import com.google.gson.annotations.SerializedName
import org.json.JSONArray

data class IngredientDataResponse(@SerializedName("results") val results: List<JSONArray>)
