package edu.iesam.superheroesdam.features.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.superheroesdam.R
import edu.iesam.superheroesdam.core.api.ApiClient
import edu.iesam.superheroesdam.features.data.SuperHeroesDataRepository
import edu.iesam.superheroesdam.features.data.remote.api.SuperHeroesApiDataSource
import edu.iesam.superheroesdam.features.domain.GetAllSuperHeroesUseCase
import kotlin.concurrent.thread


class SuperHeroesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        loadSuperHeroes()
    }
    private fun loadSuperHeroes(){
        val apiRemote = SuperHeroesApiDataSource(ApiClient())
        thread {
            val models = apiRemote.getSuperHeroes()
            models
        }
        Log.d("@dev", "Hola1")




    }
}