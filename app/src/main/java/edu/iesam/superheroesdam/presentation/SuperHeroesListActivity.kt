package edu.iesam.superheroesdam.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.superheroesdam.R
import edu.iesam.superheroesdam.data.SuperHeroesDataRepository
import edu.iesam.superheroesdam.data.remote.api.SuperHeroesApiDataSource
import edu.iesam.superheroesdam.domain.GetAllSuperHeroesUseCase
import edu.iesam.superheroesdam.domain.SuperHeroe
import edu.iesam.superheroesdam.domain.SuperHeroesRepository


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

        val superHeroesApiDataSource = SuperHeroesApiDataSource()
        val superHeroesDataRepository = SuperHeroesDataRepository(superHeroesApiDataSource)
        val getAllSuperHeroesUseCase = GetAllSuperHeroesUseCase(superHeroesDataRepository)

        val viewModel = SuperHeroesListViewModel(getAllSuperHeroesUseCase)
        viewModel.getSuperheroes().fold(
            onSuccess = {list ->
                Log.d("@dev","Esta bien")
                //TODO: DEVOLVER LA LISTA
            },
            onFailure = {error ->
                Log.d("@error","No esta bien")
            }
        )
    }

}