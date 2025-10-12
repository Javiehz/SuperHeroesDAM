package edu.iesam.superheroesdam.features.domain

interface SuperHeroesRepository {
    suspend fun getAll():Result<List<SuperHeroe>>
}