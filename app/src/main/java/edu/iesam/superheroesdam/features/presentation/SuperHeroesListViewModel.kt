package edu.iesam.superheroesdam.features.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.superheroesdam.core.ErrorApp
import edu.iesam.superheroesdam.features.domain.GetAllSuperHeroesUseCase
import edu.iesam.superheroesdam.features.domain.SuperHeroe
import kotlinx.coroutines.launch
import kotlinx.serialization.builtins.UIntArraySerializer

class SuperHeroesListViewModel(val getAllSuperHeroesUseCase: GetAllSuperHeroesUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun loadSuperHeroes(){
        viewModelScope.launch {
            _uiState.value = UiState(isLoading = true)
            getAllSuperHeroesUseCase().fold({ onSuccess(it)}, { onError(it as ErrorApp)})
        }
    }

    private fun onSuccess(superheroes: List<SuperHeroe>){
        _uiState.value = UiState(isLoading = false, superheroes = superheroes)
    }

    private fun onError(error: ErrorApp){
        _uiState.value = UiState(error = error)
    }

    data class UiState(
        val error: ErrorApp? = null,
        val isLoading: Boolean = false,
        val superheroes: List<SuperHeroe>? = null
    )
}
