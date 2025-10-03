package edu.iesam.superheroesdam.domain

interface SuperHeroesRepository {
    fun getAll():Result<List<SuperHeroe>>
}