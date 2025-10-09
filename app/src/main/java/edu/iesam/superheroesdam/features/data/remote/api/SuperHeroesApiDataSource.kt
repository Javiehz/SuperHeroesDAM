package edu.iesam.superheroesdam.features.data.remote.api

import edu.iesam.superheroesdam.core.ErrorApp
import edu.iesam.superheroesdam.features.domain.SuperHeroe

class SuperHeroesApiDataSource {


    fun getSuperHeroes(): Result<List<SuperHeroe>> {
        //ENTRAN APIMODELS (SuperHeroeApiModel)
        //SALEN MODELS (SuperHeroe)

        return Result.failure(ErrorApp.InternetError)

    }
}