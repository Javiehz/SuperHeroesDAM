package edu.iesam.superheroesdam.features.data

import edu.iesam.superheroesdam.features.data.remote.api.SuperHeroesApiDataSource
import edu.iesam.superheroesdam.features.domain.SuperHeroe
import edu.iesam.superheroesdam.features.domain.SuperHeroesRepository

class SuperHeroesDataRepository(val superHeroesApiDataSource: SuperHeroesApiDataSource):
    SuperHeroesRepository {

        override suspend fun getAll(): Result<List<SuperHeroe>> {
            return superHeroesApiDataSource.getSuperHeroes()
        }

    override suspend fun getById(id: String): Result<SuperHeroe> {
        return superHeroesApiDataSource.getSuperHeroeById(id)
    }
}