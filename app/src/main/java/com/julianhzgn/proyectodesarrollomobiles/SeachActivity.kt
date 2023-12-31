package com.julianhzgn.proyectodesarrollomobiles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.julianhzgn.proyectodesarrollomobiles.DetailRecipeActivity.Companion.EXTRA_ID
import com.julianhzgn.proyectodesarrollomobiles.databinding.ActivitySeachBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SeachActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySeachBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeachBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false

        }
        )
        adapter = RecipeAdapter { RecipeId -> navigateToDetail(RecipeId) }
        binding.rvRecipe.setHasFixedSize(true)
        binding.rvRecipe.layoutManager = LinearLayoutManager(this)
        binding.rvRecipe.adapter = adapter
    }

    private fun searchByName(query: String) {
        val apiKey = "e71fb43c3d0a4578845ec750cd79bcce"
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse = retrofit.create(ApiService::class.java).getFood(query, apiKey)
            if (myResponse.isSuccessful) {
                Log.i("Julian", "SI funciona")
                val response: IngredientDataResponse? = myResponse.body()
                if (response != null) {
                    Log.i("Julian", response.toString())
                    runOnUiThread {
                        adapter.updateList(response.results)
                        binding.progressBar.isVisible = false
                    }
                }
            } else {
                Log.i("Julian", "NO funciona")
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    private fun navigateToDetail(id: String) {
        val intent = Intent(this, DetailRecipeActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }

}