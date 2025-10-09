package edu.iesam.superheroesdam.data

import edu.iesam.superheroesdam.data.remote.api.SuperHeroesApiDataSource
import edu.iesam.superheroesdam.domain.SuperHeroe
import edu.iesam.superheroesdam.domain.SuperHeroesRepository

class SuperHeroesDataRepository(val superHeroesApiDataSource: SuperHeroesApiDataSource):
    SuperHeroesRepository {

        override fun getAll(): Result<List<SuperHeroe>> {
            return superHeroesApiDataSource.getSuperHeroes()
        }
}