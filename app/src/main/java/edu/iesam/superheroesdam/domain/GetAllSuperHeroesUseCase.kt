package edu.iesam.superheroesdam.domain

class GetAllSuperHeroesUseCase(val superHeroesRepository: SuperHeroesRepository) {
    operator fun invoke(){
        superHeroesRepository.getAll()
    }
}