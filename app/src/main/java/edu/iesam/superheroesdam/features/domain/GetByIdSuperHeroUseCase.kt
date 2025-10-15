package edu.iesam.superheroesdam.features.domain

class GetByIdSuperHeroUseCase(private val superHeroesRepository: SuperHeroesRepository) {
    suspend operator fun invoke(id: String):Result<SuperHeroe>{
        return superHeroesRepository.getById(id)
    }
}