package edu.iesam.superheroesdam.features.domain

interface SuperHeroesRepository {
    suspend fun getAll():Result<List<SuperHeroe>>
    suspend fun getById(id: String):Result<SuperHeroe>
}