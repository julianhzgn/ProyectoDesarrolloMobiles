package com.julianhzgn.proyectodesarrollomobiles

import android.R
import android.R.attr.data
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.julianhzgn.proyectodesarrollomobiles.databinding.ActivityDetailRecipeBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DetailRecipeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailRecipeBinding

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        getRecipeInformation(id)
    }

    private fun getRecipeInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val RecipeDetail = getRetrofit().create(ApiService::class.java)
                .getRecipeDetail(url = "$id/information?includeNutrition=false&apiKey=e71fb43c3d0a4578845ec750cd79bcce")

            if (RecipeDetail.body() != null) {
                Log.i("JulianInterno", RecipeDetail.toString())
                runOnUiThread { createUI(RecipeDetail.body()!!) }
            } else {
                Log.i("JulianInterno", "NO funciona")
            }
        }
    }

    private fun createUI(Recipe: RecipeDetailResponse) {
        Picasso.get().load(Recipe.image).into(binding.ivRecipeDetail)
        binding.tvRecipeDetailName.text = Recipe.title
        binding.tvRecipeDetailInfo1.text = Html.fromHtml(Recipe.summary)
        binding.tvRecipeDetailInfo3.text = Recipe.readyInMinutes
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.spoonacular.com/recipes/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

}