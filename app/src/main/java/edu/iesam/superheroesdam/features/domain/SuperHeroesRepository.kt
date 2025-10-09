package edu.iesam.superheroesdam.features.domain

interface SuperHeroesRepository {
    fun getAll():Result<List<SuperHeroe>>
}