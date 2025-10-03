package edu.iesam.superheroesdam.data.remote

import edu.iesam.superheroesdam.domain.ErrorApp
import edu.iesam.superheroesdam.domain.SuperHeroe

class SuperHeroesApiDataSource {


    fun getSuperHeroes(): Result<List<SuperHeroe>> {
        //DE MOMENTO ES PARA PRUEBAS:
        // return Result.success(listOf(SuperHeroe("1", "asdasdsa", "asdasdsa", "asdasddsa")))
        return Result.failure(ErrorApp.InternetError)
        //return Result.failure(ErrorApp.ServerErrorApp)
    }
}
