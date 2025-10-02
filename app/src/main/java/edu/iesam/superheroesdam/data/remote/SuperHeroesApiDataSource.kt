package edu.iesam.superheroesdam.data.remote

import edu.iesam.superheroesdam.domain.SuperHeroe

class SuperHeroesApiDataSource {
    fun getSuperHeroes(): Result<List<SuperHeroe>> {
        return Result.success(listOf(SuperHeroe("1", "HeroePrueba", "Hola Mundo!", ".")))
    }
}