package edu.iesam.superheroesdam.features.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import edu.iesam.superheroesdam.R
import edu.iesam.superheroesdam.core.api.ApiClient
import edu.iesam.superheroesdam.features.data.SuperHeroesDataRepository
import edu.iesam.superheroesdam.features.data.remote.api.SuperHeroesApiDataSource
import edu.iesam.superheroesdam.features.domain.GetAllSuperHeroesUseCase
import edu.iesam.superheroesdam.features.domain.GetByIdSuperHeroUseCase
import edu.iesam.superheroesdam.features.domain.SuperHeroesRepository
import kotlin.concurrent.thread


class SuperHeroesListActivity : AppCompatActivity() {

    private val listViewModel = SuperHeroesListViewModel(
        GetAllSuperHeroesUseCase(
            SuperHeroesDataRepository(
                SuperHeroesApiDataSource(ApiClient()))))

    private val heroeViewModel = SuperHeroeViewModel(GetByIdSuperHeroUseCase(
        SuperHeroesDataRepository(SuperHeroesApiDataSource(ApiClient()))))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        setupHeroObserver()
        setupListHeroesObserver()

        heroeViewModel.loadSuperHero("2")
        listViewModel.loadSuperHeroes()
    }

    private fun setupHeroObserver() {
        val observer = Observer<SuperHeroeViewModel.UiState> { uiState ->
            if (uiState.isLoading) {
                Log.d("DEBUG", "Cargando superhéroe...")
            }

            uiState.error?.let {
                Log.e("DEBUG", "Error al cargar superhéroe: $it")
            }

            uiState.superhero?.let { hero ->
                Log.d("DEBUG", "Superhéroe recibido: $hero")
                // Aquí actualizarías tu UI con hero.name, hero.power, etc.
                hero
            }
        }

        heroeViewModel.uiState.observe(this, observer)
    }

    private fun setupListHeroesObserver(){
        val observer = Observer<SuperHeroesListViewModel.UiState>{ uiState ->
            if(uiState.isLoading){
                //TODO: Mostrar spinner de carga.
            } else {
                //TODO: Ocultar spinner de carga.
            }
            uiState.error?.let { error ->
                //TODO: Mostrar error (por ejemplo un Toast)
            }

            uiState.superheroes?.let { superheroes ->
               //TODO: Añadir superheroes interfaz superheroes
                superheroes
            }

        }
        listViewModel.uiState.observe(this, observer)
    }
}