package edu.iesam.superheroesdam.features.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.superheroesdam.core.ErrorApp
import edu.iesam.superheroesdam.features.domain.GetByIdSuperHeroUseCase
import edu.iesam.superheroesdam.features.domain.SuperHeroe
import kotlinx.coroutines.launch

class SuperHeroeViewModel(val getSuperHeroByIdUseCase: GetByIdSuperHeroUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun loadSuperHero(id: String){
        viewModelScope.launch {
            _uiState.value = UiState(isLoading = true)
            getSuperHeroByIdUseCase(id).fold(
                { onSuccess(it) },
                { onError(it as ErrorApp) }
            )
        }
    }

    private fun onSuccess(superhero: SuperHeroe){
        _uiState.value = UiState(isLoading = false, superhero = superhero)
    }

    private fun onError(error: ErrorApp){
        _uiState.value = UiState(error = error)
    }

    data class UiState(
        val error: ErrorApp? = null,
        val isLoading: Boolean = false,
        val superhero: SuperHeroe? = null
    )
}