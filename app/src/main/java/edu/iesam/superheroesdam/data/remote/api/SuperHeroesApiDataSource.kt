package edu.iesam.superheroesdam.data.remote.api

import edu.iesam.superheroesdam.domain.ErrorApp
import edu.iesam.superheroesdam.domain.SuperHeroe

class SuperHeroesApiDataSource {


    fun getSuperHeroes(): Result<List<SuperHeroe>> {
        //ENTRAN APIMODELS (SuperHeroeApiModel)
        //SALEN MODELS (SuperHeroe)

        return Result.failure(ErrorApp.InternetError)

    }
}