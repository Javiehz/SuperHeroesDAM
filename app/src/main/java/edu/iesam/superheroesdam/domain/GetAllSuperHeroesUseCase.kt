package edu.iesam.superheroesdam.domain

class GetAllSuperHeroesUseCase(val superHeroesRepository: SuperHeroesRepository) {
    operator fun invoke():Result<List<SuperHeroe>>{
        return superHeroesRepository.getAll()
    }
}