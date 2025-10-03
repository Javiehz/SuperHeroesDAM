package edu.iesam.superheroesdam.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.superheroesdam.domain.GetAllSuperHeroesUseCase
import edu.iesam.superheroesdam.domain.SuperHeroe

class SuperHeroesListViewModel(val getAllSuperHeroesUseCase: GetAllSuperHeroesUseCase) : ViewModel() {

    fun getSuperheroes(): Result<List<SuperHeroe>> {
        return getAllSuperHeroesUseCase.invoke()
    }
}
