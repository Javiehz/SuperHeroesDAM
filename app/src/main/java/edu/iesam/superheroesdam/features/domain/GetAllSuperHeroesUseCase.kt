package edu.iesam.superheroesdam.features.domain

class GetAllSuperHeroesUseCase(val superHeroesRepository: SuperHeroesRepository) {
    suspend operator fun invoke():Result<List<SuperHeroe>>{
        return superHeroesRepository.getAll()
    }
}