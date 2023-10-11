package com.julianhzgn.proyectodesarrollomobiles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import com.julianhzgn.proyectodesarrollomobiles.databinding.ActivitySeachBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SeachActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySeachBinding
    private lateinit var retrofit: Retrofit

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
    }

    private fun searchByName(query: String) {
        val apiKey = "e71fb43c3d0a4578845ec750cd79bcce"

        CoroutineScope(Dispatchers.IO).launch {
            val myResponse = retrofit.create(ApiService::class.java).getFood(query, apiKey)
            if (myResponse.isSuccessful) {
                Log.i("Julian", "SI funciona")
            } else {
                Log.i("Julian", "NO funciona")
            }
        }
    }




    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

}