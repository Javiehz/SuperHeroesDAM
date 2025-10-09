package edu.iesam.superheroesdam.features.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.superheroesdam.features.domain.GetAllSuperHeroesUseCase
import edu.iesam.superheroesdam.features.domain.SuperHeroe

class SuperHeroesListViewModel(val getAllSuperHeroesUseCase: GetAllSuperHeroesUseCase) : ViewModel() {

    fun getSuperheroes(): Result<List<SuperHeroe>> {
        return getAllSuperHeroesUseCase.invoke()
    }
}
